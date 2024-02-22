package com.example.kotlin.playground.kotlinx.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import strikt.api.expectThat
import strikt.assertions.containsExactly
import strikt.assertions.isEqualTo
import kotlin.test.Test
import kotlin.test.assertEquals

class CoroutinesTest {

  @Test
  fun testSimple() {
    val data1 = mutableListOf<String>()
    simpleRunBlocking(data1)
    assertEquals(data1, listOf("Hello", "World!"))

    val data2 = mutableListOf<String>()
    simpleRunBlockingWithSuspendFun(data2)
    assertEquals(data2, listOf("Hello", "World!"))
  }

  /**
   * The name of runBlocking means that the thread that runs it (in this case — the main thread) gets blocked
   * for the duration of the call, until all the coroutines inside runBlocking { ... } complete their execution.
   */
  fun simpleRunBlocking(data: MutableList<String>) = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
      smallDelay()
      data += "World!" // print after delay
    }
    data += "Hello" // main coroutine continues while a previous one is delayed
  }

  fun simpleRunBlockingWithSuspendFun(data: MutableList<String>) =
    runBlocking { // this: CoroutineScope
      launch { simpleSuspendBlock(data) }
      data += "Hello" // main coroutine continues while a previous one is delayed
    }

  suspend fun simpleSuspendBlock(data: MutableList<String>) {
    smallDelay()
    data += "World!" // print after delay
  }

  @Test
  fun testCoroutineScope() {
    runBlocking {
      val data1 = mutableListOf<String>()
      simpleSuspendCoroutineScope(data1)
      assertEquals(data1, listOf("Hello", "World!"))
    }
  }

  suspend fun simpleSuspendCoroutineScope(data: MutableList<String>) =
    coroutineScope {  // this: CoroutineScope
      launch { // launch a new coroutine and continue
        smallDelay()
        data += "World!" // print after delay
      }
      data += "Hello" // main coroutine continues while a previous one is delayed
    }

  // non-blocking delay for x ms (default time unit is ms)
  private suspend fun smallDelay(factor: Float = 1.0f) {
    delay((100L * factor).toLong())
  }

  // Sequentially executes doWorld followed by "Done"
  @Test
  fun testScopeBuilderAndConcurrency() {
    runBlocking {
      val data = mutableListOf<String>()
      scopeBuilderAndConcurrency(data)
      assertEquals(data, listOf("Hello", "World 1", "World 2"))
      println("Done")
    }
  }

  // Concurrently executes both sections
  suspend fun scopeBuilderAndConcurrency(data: MutableList<String>) =
    coroutineScope { // this: CoroutineScope
      launch {
        smallDelay(2f)
        data += "World 2"
      }
      launch {
        smallDelay()
        data += "World 1"
      }
      data += "Hello"
    }

  @Test
  fun explicitJob() {
    val data = mutableListOf<String>()
    runBlocking {

      val job = launch { // launch a new coroutine and keep a reference to its Job
        smallDelay()
        data += "World!"
      }
      data += "Hello"
      job.join() // wait until child coroutine completes
      data += "Done"
    }

    expectThat(data)
      .containsExactly("Hello", "World!", "Done")
  }

  @Test
  fun coroutines_are_lightweight() {
    var data = ""
    runBlocking {
      repeat(50_000) { // launch a lot of coroutines
        launch {
          smallDelay()
          data += "."
        }
      }
    }
    expectThat(data)
      .isEqualTo(".".repeat(50_000))
  }
}