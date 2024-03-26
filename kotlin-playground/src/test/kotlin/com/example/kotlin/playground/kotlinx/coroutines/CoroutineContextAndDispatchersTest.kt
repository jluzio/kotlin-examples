package com.example.kotlin.playground.kotlinx.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.slf4j.LoggerFactory
import strikt.api.expectThat
import strikt.assertions.contains
import strikt.assertions.containsExactly
import strikt.assertions.isEmpty
import kotlin.test.Test

class CoroutineContextAndDispatchersTest {

  val log = LoggerFactory.getLogger(this::class.java)

  @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
  @Test
  fun dispatchersAndThreads() = runTest {
    launch { // context of the parent, main runBlocking coroutine
      println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
      println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
      println("Default               : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
      println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
    }
  }

  @Test
  fun unconfined_vs_confined() = runTest {
    /*
      The coroutine with the context inherited from runBlocking {...} continues to execute in the main thread,
      while the unconfined one resumes in the default executor thread that the delay function is using.
     */
    launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
      println("Unconfined      : I'm working in thread ${Thread.currentThread().name}")
      delay(500)
      println("Unconfined      : After delay in thread ${Thread.currentThread().name}")
    }
    launch { // context of the parent, main runBlocking coroutine
      println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
      delay(1000)
      println("main runBlocking: After delay in thread ${Thread.currentThread().name}")
    }
    println("Launched tasks")
  }

  @Test
  fun cancelPropagation() = runTest {
    // launch a coroutine to process some kind of incoming request
    val executions = mutableListOf<String>()
    val request = launch {
      // it spawns two other jobs
      launch(Job()) {
        log.info("job1: I run in my own Job and execute independently!")
        delay(1000)
        log.info("job1: I am not affected by cancellation of the request")
        executions.add("job1")
      }
      // and the other inherits the parent context
      launch {
        delay(100)
        log.info("job2: I am a child of the request coroutine")
        delay(1000)
        log.info("job2: I will not execute this line if my parent request is cancelled")
        executions.add("job2")
      }
    }
    delay(500)

    request.cancel() // cancel processing of the request

    log.info("main: Who has survived request cancellation?")
    expectThat(executions).isEmpty()

    delay(1000) // delay the main thread for a second to see what happens
    expectThat(executions).containsExactly("job1")
  }

  @Test
  fun parentPropagatingActionToChildren() = runTest {
    val executions = mutableListOf<Int>()
    val request = launch {
      repeat(3) { i -> // launch a few children jobs
        launch {
          delay((i + 1) * 200L) // variable delay 200ms, 400ms, 600ms
          println("Coroutine $i is done")
          executions.add(i)
        }
      }
      println("request: I'm done and I don't explicitly join my children that are still active")
    }
    request.join() // wait for completion of the request, including all its children
    println("Now processing of the request is complete")
    expectThat(executions).contains(0, 1, 2)
  }

  @Test
  fun threadLocalContext() = runTest {
    val threadLocal = ThreadLocal<String>()
    threadLocal.set("main")
    println("Pre-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
    val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "launch")) {
      println("Launch start, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
      yield()
      println("After yield, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
    }
    job.join()
    println("Post-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
  }
}