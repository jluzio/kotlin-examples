package com.example.kotlin.course.collections

fun main() {
  val stringList = mutableListOf("spring", "summer", "fall", "stuff", "red")
  val colorList = mutableListOf("black", "red", "green")
  val intList = listOf(3, 5, 2, 7)

  println(intList.getOrNull(5))
  val retGetOrElse = intList.getOrElse(5, { "no value found at index $it" })
  println(retGetOrElse)

  println(colorList.last())

  val reversedList = colorList.reversed()
  println(reversedList)
  val reversedViewOfList = colorList.asReversed()
  println(reversedViewOfList)

  colorList += "blue"
  println(reversedList)
  println(reversedViewOfList)

  println(colorList.max())

  println(colorList + stringList)

  // no dups
  println(colorList.union(stringList))
  println((colorList + stringList).distinct())

  println(listOf(1, 2, 3, 4, 5).slice(0..2))
  println(listOf(1, 2, 3, 4, 5).slice(0..99))

}