package com.example.kotlin.course.expressions

fun main() {
  val num = 200

  when (num) {
    100 -> println("100")
    200 -> println("200")
    else -> println("else")
  }

  val result = when (num) {
    100, 150 -> "100 or 150"
    in 151..200 -> "in 151..200"
    else -> "else"
  }
  println(result)

  val numAny: Any = 199
  println(
    when (numAny) {
      100, 150 -> "100 or 150"
      is String -> "string"
      is Int -> "int"
      in 151..200 -> "in 151..200"
      else -> "else"
    }
  )

  when {
    num > 100 -> println("gt 100")
    num < 100 -> println("lt 100")
  }

}