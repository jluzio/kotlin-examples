package com.example.kotlin.playground.testing

import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.springframework.stereotype.Component
import kotlin.test.Test

class MockTest {
  open class Hello() {

    open fun sayHello(target: String) = "Hello $target!"
  }

  @Mockable
  class FinalHello() {

    fun sayHello(target: String) = "Hello $target!"
  }

  @MockableV2
  class FinalHello2() {

    fun sayHello(target: String) = "Hello $target!"
  }

  @Component
  class ComponentHello() {

    fun sayHello(target: String) = "Hello $target!"
  }

  @Test
  fun test() {
    val mock = mock<Hello> {
      on { sayHello(any()) } doReturn "Bamboozled"
    }
    println(mock.sayHello("world"))
  }

  @Test
  fun test_final() {
    val mock = mock<FinalHello> {
      on { sayHello(any()) } doReturn "Bamboozled"
    }
    println(mock.sayHello("world"))

    val mock2 = mock<FinalHello2> {
      on { sayHello(any()) } doReturn "Bamboozled"
    }
    whenever(mock2.sayHello(any())).thenReturn("Bamboozled")
    println(mock2.sayHello("world"))
  }

  @Test
  fun test_spring() {
    val mock = mock<ComponentHello> {
      on { sayHello(any()) } doReturn "Bamboozled"
    }
    println(mock.sayHello("world"))
  }

}