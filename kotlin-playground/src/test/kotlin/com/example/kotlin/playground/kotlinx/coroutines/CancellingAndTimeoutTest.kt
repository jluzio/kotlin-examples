package com.example.kotlin.playground.kotlinx.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.slf4j.LoggerFactory
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isNull
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.Test
import kotlin.test.assertEquals

class CancellingAndTimeoutTest {

  val log = LoggerFactory.getLogger(this::class.java)

  @Test
  fun cancelling() = runTest {
    val executions = AtomicInteger(0)
    val job = launch {
      repeat(1000) { i ->
        println("job: I'm sleeping $i ...")
        executions.incrementAndGet()
        delay(500L)
      }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    job.join() // waits for job's completion
    println("main: Now I can quit.")
    expectThat(executions.get()).isEqualTo(3)
  }

  @Test
  fun cantCancelExample1(): Unit = runBlocking {
    val executions = AtomicInteger(0)
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
      var nextPrintTime = startTime
      var i = 0
      while (i < 5) { // computation loop, just wastes CPU
        // print a message twice a second / 10
        if (System.currentTimeMillis() >= nextPrintTime) {
          println("job: I'm sleeping ${i++} ...")
          executions.incrementAndGet()
          nextPrintTime += 50L
        }
      }
    }
    delay(130L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
    expectThat(executions.get()).isEqualTo(5)
  }

  @Test
  fun cantCancelExample2(): Unit = runBlocking {
    val executions = AtomicInteger(0)
    val job = launch(Dispatchers.Default) {
      repeat(5) { i ->
        try {
          // print a message twice a second / 10
          println("job: I'm sleeping $i ...")
          executions.incrementAndGet()
          delay(50)
        } catch (e: Exception) {
          // log the exception
          println(e)
        }
      }
    }
    delay(130L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
    expectThat(executions.get()).isEqualTo(5)
  }

  @Test
  fun allowCancel(): Unit = runBlocking {
    val executions = AtomicInteger(0)
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
      var nextPrintTime = startTime
      var i = 0
      while (isActive) { // cancellable computation loop
        // print a message twice a second / 10
        if (System.currentTimeMillis() >= nextPrintTime) {
          println("job: I'm sleeping ${i++} ...")
          executions.incrementAndGet()
          nextPrintTime += 100L
        }
      }
    }
    delay(250L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
    expectThat(executions.get()).isEqualTo(3)
  }

  @Test
  fun nonCancellableBlock(): Unit = runBlocking {
    val executions = AtomicInteger(0)
    val job = launch {
      try {
        repeat(1000) { i ->
          println("job: I'm sleeping $i ...")
          delay(50L)
        }
      } finally {
        withContext(NonCancellable) {
          println("job: I'm running finally")
          delay(100L)
          println("job: And I've just delayed for 1 sec because I'm non-cancellable")
          executions.incrementAndGet()
        }
      }
    }
    delay(130L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
    assertEquals(1, executions.get())
  }

  @Test
  fun timeout() = runTest {
    val executions = AtomicInteger(0)
    try {
      withTimeout(1300L) {
        repeat(1000) { i ->
          println("I'm sleeping $i ...")
          executions.incrementAndGet()
          delay(500L)
        }
      }
    } catch (e: TimeoutCancellationException) {
      log.debug("Caught: {}", e.message)
    }
    expectThat(executions.get()).isEqualTo(3)
  }

  @Test
  fun timeoutOrNull() = runTest {
    val executions = AtomicInteger(0)
    val result = withTimeoutOrNull(1300L) {
      repeat(1000) { i ->
        println("I'm sleeping $i ...")
        executions.incrementAndGet()
        delay(500L)
      }
      "Done"
    }
    expectThat(result).isNull()
    expectThat(executions.get()).isEqualTo(3)
  }
}