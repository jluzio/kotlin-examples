package com.example.kotlin.playground

import org.junit.jupiter.api.Test


class OperatorOverloadingTest {

  data class MyNumber(val value: String) {

    operator fun plus(other: String): MyNumber {
      val intSum = value.toInt() + other.toInt()
      return MyNumber(intSum.toString())
    }

    operator fun plus(other: MyNumber): MyNumber {
      return plus(other.value)
    }

    operator fun invoke(s: String): MyNumber {
      println("$s | $this")
      return this
    }
  }

  @Test
  fun operator_plus_test() {
    val n1 = MyNumber("1")
    val n2 = n1 + "2"
    val n3 = n2 + MyNumber("3")
    println("values: $n1 | $n2 | $n3")
  }

  @Test
  fun operator_invoke_test() {
    val number = MyNumber("3")

    // invoke
    number("msg1")
    // invoke x2
    number("msg2-1")("msg2-2")
  }

}