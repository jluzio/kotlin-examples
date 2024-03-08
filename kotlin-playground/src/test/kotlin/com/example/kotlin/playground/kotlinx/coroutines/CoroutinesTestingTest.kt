package com.example.kotlin.playground.kotlinx.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.currentTime
import kotlinx.coroutines.test.runTest
import org.slf4j.LoggerFactory
import strikt.api.expectThat
import strikt.assertions.containsExactly
import kotlin.test.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/**
 * @see https://github.com/Kotlin/kotlinx.coroutines/blob/master/kotlinx-coroutines-test/README.md
 * NOTE: activate -Dkotlinx.coroutines.debug to view coroutines in logs
 */
class CoroutinesTestingTest {

  val log = LoggerFactory.getLogger(this::class.java)

  @Test
  fun testSimple() = runTest {
    val values = mutableListOf<String>()
    log.info("Start")
    val job = launch {
      delay(20.seconds)
      values += "World!"
    }
    values += "Hello"
    log.info("End")

    job.join()
    log.info("Join")

    log.info("Values: {}", values)
    expectThat(values)
      .containsExactly("Hello", "World!")
  }

  @Test
  fun testSkipDelay() = runTest {
    delay(10_000) // when run in `runTest`, will finish immediately instead of delaying
  }

  @Test
  // default timeout is 10s, use timeout var when it takes longer than that
  fun testHanging() = runTest(timeout = 30.seconds) {
    val result = withContext(Dispatchers.Default) {
      // this delay is not in the test dispatcher and will not be skipped
//      delay(20.seconds)
      delay(1.seconds)
      3
    }
    assertEquals(3, result)
  }

  @Test
  @OptIn(ExperimentalTime::class, ExperimentalCoroutinesApi::class)
  fun testFoo() = runTest {
    launch {
      val workDuration = testScheduler.timeSource.measureTime {
        println(1)   // executes during runCurrent()
        delay(1_000) // suspends until time is advanced by at least 1_000
        println(2)   // executes during advanceTimeBy(2_000)
        delay(500)   // suspends until the time is advanced by another 500 ms
        println(3)   // also executes during advanceTimeBy(2_000)
        delay(5_000) // will suspend by another 4_500 ms
        println(4)   // executes during advanceUntilIdle()
      }
      assertEquals(6500.milliseconds, workDuration) // the work took 6_500 ms of virtual time
    }
    // the child coroutine has not run yet
    testScheduler.runCurrent()
    // the child coroutine has called println(1), and is suspended on delay(1_000)
    testScheduler.advanceTimeBy(2.seconds) // progress time, this will cause two calls to `delay` to resume
    // the child coroutine has called println(2) and println(3) and suspends for another 4_500 virtual milliseconds
    testScheduler.advanceUntilIdle() // will run the child coroutine to completion
    assertEquals(
      6500,
      currentTime
    ) // the child coroutine finished at virtual time of 6_500 milliseconds
  }

  @OptIn(ExperimentalCoroutinesApi::class)
  @Test
  fun testWithMultipleDispatchers() = runTest {
    val scheduler = testScheduler // the scheduler used for this test
    val dispatcher1 = StandardTestDispatcher(scheduler, name = "IO dispatcher")
    val dispatcher2 = StandardTestDispatcher(scheduler, name = "Background dispatcher")
    launch(dispatcher1) {
      delay(1_000)
      println("1. $currentTime") // 1000
      delay(200)
      println("2. $currentTime") // 1200
      delay(2_000)
      println("4. $currentTime") // 3200
    }
    val deferred = async(dispatcher2) {
      delay(3_000)
      println("3. $currentTime") // 3000
      delay(500)
      println("5. $currentTime") // 3500
    }
    deferred.await()
  }

  @OptIn(ExperimentalCoroutinesApi::class)
  @Test
  fun testEagerlyEnteringChildCoroutines() = runTest(UnconfinedTestDispatcher()) {
    var entered = false
    val deferred = CompletableDeferred<Unit>()
    var completed = false
    launch {
      entered = true
      deferred.await()
      completed = true
    }
    assertTrue(entered) // `entered = true` already executed.
    assertFalse(completed) // however, the child coroutine then suspended, so it is enqueued.
    deferred.complete(Unit) // resume the coroutine.
    assertTrue(completed) // now the child coroutine is immediately completed.
  }

  @Test
  fun testFooWithTimeout() = runTest {
    assertFailsWith<TimeoutCancellationException> {
      withTimeout(1_000) {
        delay(999)
        delay(2)
        println("this won't be reached")
      }
    }
  }

  @OptIn(ExperimentalCoroutinesApi::class)
  @Test
  fun testDelayInSuspend() = runTest {
    val realStartTime = System.currentTimeMillis()
    val virtualStartTime = currentTime

    foo()
    log.info("${System.currentTimeMillis() - realStartTime} ms") // ~ 6 ms
    log.info("${currentTime - virtualStartTime} ms")             // 1000 ms
  }

  private suspend fun foo() {
    delay(1000)    // auto-advances without delay
    log.info("foo") // executes eagerly when foo() is called
  }

  @OptIn(ExperimentalCoroutinesApi::class)
  @Test
  fun testDelayInLaunch() = runTest {
    val realStartTime = System.currentTimeMillis()
    val virtualStartTime = currentTime

    bar()

    println("${System.currentTimeMillis() - realStartTime} ms") // ~ 11 ms
    println("${currentTime - virtualStartTime} ms")             // 1000 ms
  }

  private suspend fun bar() = coroutineScope {
    launch {
      delay(1000)    // auto-advances without delay
      println("bar") // executes eagerly when bar() is called
    }
  }
}