package com.example.kotlin.course.collections

fun main() {
  val values = listOf("Task1Aaa", "Task1Zzz", "Task1Debug", "Task2Aaa", "Task2Zzz", "Task2Debug")

  fun booleanToInt(b: Boolean) = if (b) 1 else 0
  val sortedValues = values.sortedWith(
    Comparator<String> { o1, o2 ->
      when {
        o1.contains("Debug") == o2.contains("Debug") -> 0
        o1.contains("Debug") -> 1
        else -> -1
      }
    }.thenBy { it }
  )
  println(sortedValues)

}

