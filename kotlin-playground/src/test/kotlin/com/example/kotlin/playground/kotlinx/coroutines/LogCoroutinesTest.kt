package com.example.kotlin.playground.kotlinx.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class LogCoroutinesTest {
  val log = LoggerFactory.getLogger(this::class.java)

  /*
   Run the code with -Dkotlinx.coroutines.debug
   */
  @Test
  fun logTest() = runBlocking<Unit> {
    val a = async {
      debugMsgAll("I'm computing a piece of the answer")
      6
    }
    val b = async {
      debugMsgAll("I'm computing another piece of the answer")
      7
    }
    debugMsgAll("The answer is ${a.await() * b.await()}")
  }

  @Test
  fun namedCoroutines() = runTest {
    debugMsgAll("Started main coroutine")
// run two background value computations
    val v1 = async(CoroutineName("v1coroutine")) {
      delay(500)
      logMsg("Computing v1")
      252
    }
    // adding CoroutineName with a base context
    val v2 = async(this.coroutineContext + CoroutineName("v2coroutine")) {
      delay(1000)
      logMsg("Computing v2")
      6
    }
    logMsg("The answer for v1 / v2 = ${v1.await() / v2.await()}")
  }

  fun debugMsgAll(msg: String) {
    logMsg(msg)
    printMsg(msg)
  }
  fun logMsg(msg: String) = log.info(msg)
  fun printMsg(msg: String) = println("[${Thread.currentThread().name}] $msg")
}