package org.example.kotlin.playground.testing

import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.springframework.stereotype.Component

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
    val mock = mock<Hello>()
    whenever(mock.sayHello(any())).thenReturn("Bamboozled")
    println(mock.sayHello("world"))
  }

  @Test
  fun test_final() {
    val mock = mock<FinalHello>()
    whenever(mock.sayHello(any())).thenReturn("Bamboozled")
    println(mock.sayHello("world"))

    val mock2 = mock<FinalHello2>()
    whenever(mock2.sayHello(any())).thenReturn("Bamboozled")
    println(mock2.sayHello("world"))
  }

  @Test
  fun test_spring() {
    val mock = mock<ComponentHello>()
    whenever(mock.sayHello(any())).thenReturn("Bamboozled")
    println(mock.sayHello("world"))
  }

}