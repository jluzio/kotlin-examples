package com.example.kotlin.playground.kotlinx.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class DebugCoroutinesTest {


  @Test
  fun debugTest() = runBlocking<Unit> {
    // DEBUG any coroutine statement, and check the Coroutines tab
    // (also Memory and Overhead tabs, note that they may be hidden by default)
    val a = async {
      println("I'm computing part of the answer")
      6
    }
    val b = async {
      println("I'm computing another part of the answer")
      7
    }
    println("The answer is ${a.await() * b.await()}")
  }

  @Test
  fun suspendTest() = runTest {
    // Optimized-out variables
    // use -Xdebug in the compiler options to disable optimization, but don't use in production
    suspendedFunc()
  }

  private suspend fun suspendedFunc() {
    val a = 1L
    delay(a)
    println("Slept for 1ms")
  }

}