package org.example.kotlin.playground

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail


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

    val (v1, v2, v3) = list
    println("values: $v1, $v2, $v3")

    try {
      val (v1, v2, v3, v4) = list
      println("values: $v1, $v2, $v3, $v4")
      fail("expecting IndexOutOfBounds type exception")
    } catch (e: Exception) {
    }
  }
}