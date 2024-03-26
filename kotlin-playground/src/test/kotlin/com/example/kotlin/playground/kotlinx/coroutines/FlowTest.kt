package com.example.kotlin.playground.kotlinx.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.yield
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.contains
import strikt.assertions.isEqualTo
import strikt.assertions.isNull

class FlowTest {

  // NOTE: Flow is type of coroutine, so things like withTimeout work also

  @Test
  fun testSimple() = runTest {
    fun simple(): Flow<Int> = flow {
      for (i in 1..3) {
        delay(100)
        println("Emitting $i")
        emit(i)
      }
    }

    val values = simple()
      .onEach { value -> println(value) }
      .toList()
    expectThat(values)
      .isEqualTo((1..3).toList())

    val sameAsSimpleFlow = (1..3).asFlow()
      .onEach { delay(100) }
      .onEach { println("Emitting $it") }
    expectThat(sameAsSimpleFlow.toList())
      .isEqualTo((1..3).toList())
  }

  @Test
  fun testTimeout() = runTest {
    fun simple(): Flow<Int> = flow {
      for (i in 1..3) {
        delay(100)
        println("Emitting $i")
        emit(i)
      }
    }

    val results = withTimeoutOrNull(250) { // Timeout after 250ms
      simple()
        .onEach { value -> println(value) }
        .toList()
    }
    println("Done")
    expectThat(results).isNull()
  }

}