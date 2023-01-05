package com.example.kotlin.playground

import org.assertj.core.api.Assertions.assertThat
import com.example.kotlin.playground.helper.LogDelegate
import org.junit.jupiter.api.Test
import kotlin.reflect.jvm.javaMethod

class MiscTest {

  private val log by com.example.kotlin.playground.helper.LogDelegate()

  @Test
  fun static_call() {
    println(String::class)
  }

  @Test
  fun test_exception() {
    val method = this::declare_exception.javaMethod
    val exceptions = method!!.exceptionTypes.toList()
    assertThat(exceptions)
      .contains(IllegalArgumentException::class.java, UnsupportedOperationException::class.java)
    log.debug(exceptions.toString())
  }

  @Throws(IllegalArgumentException::class, UnsupportedOperationException::class)
  fun declare_exception() {
    throw IllegalArgumentException("test")
  }

}