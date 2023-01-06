package com.example.kotlin.course.collections

fun main() {
  val setInts = setOf(1, 4, 3)
  println(setInts.javaClass)
  println(setInts.plus(6))
  println(setInts + 7)
  println(setInts.plus(3))

  val mutableInts = setInts.toMutableSet()
  println(mutableInts.javaClass)
  println(mutableInts + 123)
  println(mutableInts)
}