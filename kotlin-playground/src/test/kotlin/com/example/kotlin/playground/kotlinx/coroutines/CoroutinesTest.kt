package com.example.kotlin.playground.kotlinx.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CoroutinesTest {

  @Test
  fun testSimple() {
    val data = mutableListOf<String>()
    runSimple(data)
    assertThat(data)
      .containsExactly("Hello", "World!")
  }

  fun runSimple(data: MutableList<String>) = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
      delay(100L) // non-blocking delay for 1 second (default time unit is ms)
      data += "World!" // print after delay
    }
    data += "Hello" // main coroutine continues while a previous one is delayed
  }

}