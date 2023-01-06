package com.example.kotlin.course.classes

fun printAll(vararg values: String) = println("values: ${values.toList()}")

fun main() {
  printAll("a", "b", "c")
  val values = arrayOf("a", "b", "c")
  val allValues = arrayOf("d", *values)
  printAll(*allValues)
}