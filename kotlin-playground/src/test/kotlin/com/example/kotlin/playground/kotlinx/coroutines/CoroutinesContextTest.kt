package com.example.kotlin.playground.kotlinx.coroutines

import kotlinx.coroutines.*
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.test.Test

/**
 * NOTE: activate -Dkotlinx.coroutines.debug to view coroutines in logs
 */
class CoroutinesContextTest {

  @Test
  fun async_default() {
    runBlocking {
      // use EmptyCoroutineContext thread dispatcher
      launch(EmptyCoroutineContext) {
        val deferredResult = async {
          loadData()
        }
        expectThat(deferredResult.await())
          .isEqualTo(42)
      }
    }
  }

  @Test
  fun async_dispatcher_default() {
    runBlocking {
      // use Default thread dispatcher
      launch(Dispatchers.Default) {
        val deferredResult = async {
          loadData()
        }
        withContext(EmptyCoroutineContext) {
          expectThat(deferredResult.await())
            .isEqualTo(42)
        }
      }
    }
  }

  private suspend fun loadData(): Int {
    println("loading...")
    delay(200L)
    println("loaded!")
    return 42
  }
}