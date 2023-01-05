package com.example.kotlin.playground

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.fail
import java.lang.IndexOutOfBoundsException


class DestructuringDeclarationsTest {

  data class DataClass(val foo: String, val bar: String)
  class NoDataClass(val foo: String, val bar: String) {

    operator fun component1() = foo
    operator fun component2() = bar
  }

  @Test
  fun destructuring_data_class() {
    fun funThatReturnsData() = DataClass("foo1", "bar1")
    val (foo, bar) = funThatReturnsData()
    println("foo: $foo, bar: $bar")

    val (_, bar2) = funThatReturnsData()
    println("bar: $bar2")
  }

  @Test
  fun destructuring_class() {
    fun funThatReturnsNoData() = NoDataClass("foo1", "bar1")
    val (foo, bar) = funThatReturnsNoData()
    println("foo: $foo, bar: $bar")
  }

  @Test
  fun destructuring_map_lambdas() {
    var map = mapOf("a" to 1, "b" to 2)
    for ((key, value) in map) {
      println("key: $key, value: $value")
    }

    map.mapValues { }
  }

  @Test
  fun destructuring_list() {
    var list = listOf(1, 2, 3)

    assertDoesNotThrow {
      val (v1, v2, v3) = list
      println("values: $v1, $v2, $v3")
    }

    assertThatThrownBy {
      val (v1, v2, v3, v4) = list
      println("values: $v1, $v2, $v3, $v4")
    }.isInstanceOf(IndexOutOfBoundsException::class.java)
  }
}