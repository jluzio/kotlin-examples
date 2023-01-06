package com.example.kotlin.course.expressions

fun main() {
  val if_r1 = if (1 > 2) 32 else 42
  println(if_r1)
  println(
    if (1 > 2) {
      println("case 1")
      32
    } else {
      println("case 2")
      42
    }
  )
  println(
    if (1 > 2) {
      println("case 1")
    } else {
      println("case 2")
    }
  )
}