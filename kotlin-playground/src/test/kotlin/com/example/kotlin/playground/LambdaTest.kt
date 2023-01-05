package com.example.kotlin.playground

import org.junit.jupiter.api.Test


class LambdaTest {

  @Test
  fun representations() {
    var someNumber = 42
    fun tester(msg: String, log: (Int) -> (String)) {
      someNumber++
      println("$msg | ${log(someNumber)}")
    }

    tester("test-1: lambda", {
      "implicit-$it"
    })
    tester("test-2: implicit lambda") {
      "implicit-$it"
    }
    tester("test-3: lambda") { v ->
      "implicit-$v"
    }
    tester("test-4: fun", fun(i: Int) = "with fun-$i")
  }

  @Test
  fun for_each_indexed() {
    val list = listOf("a", "b", "C")
    list.forEachIndexed { i, v ->
      println("$i | $v ")
    }
  }
}