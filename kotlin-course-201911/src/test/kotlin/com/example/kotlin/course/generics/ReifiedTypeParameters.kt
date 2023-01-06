package com.example.kotlin.course.generics

import java.util.*

fun main() {
  val mixedList = listOf("aaa", 111, Date())
  val stringList = filterByType<String>(mixedList)
  println(stringList)
}

inline fun <reified T> filterByType(values: Iterable<*>): List<T> {
//    return values.filterIsInstance<T>()
  val typeValues = mutableListOf<T>()
  for (v in values) {
    if (v is T) typeValues.add(v)
  }
  return typeValues
}