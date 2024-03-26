package com.example.kotlin.playground.kotlinx.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class DebugFlowTest {


  @Test
  fun debugTest() = runBlocking {
    simple()
      .collect { value ->
        delay(300)
        println(value)
      }
  }

  fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
      delay(100)
        emit(i)
    }
  }

  @Test
  fun concurrency() = runBlocking<Unit> {
    // no changes to the number of coroutines in debug, from the first test
    // documentation is wrong?
    simple()
      .buffer()
      .collect { value ->
        delay(300)
        println(value)
      }
  }
}