package com.example.kotlin.course.collections

/*
 Sequences == Streams
 Used when chaining of methods creates expensive middle collections.
 Only use when we have large collections, because kotlin collections are very efficient
 */

fun main() {
  val carMap = mapOf<Int, Car>(
    (1 to Car("green", "Toyota", 2015)),
    (2 to Car("red", "Ford", 2016)),
    (3 to Car("silver", "Honda", 2013)),
    (17 to Car("red", "BMW", 2015)),
    (8 to Car("green", "Ford", 2010))
  )

  println("normal example: " + carMap.filter { it.value.model == "Ford" }.map { it.value.color })

  val sequence = carMap.asSequence()
    .filter { println("filter"); it.value.model == "Ford" }
    .map { println("map"); it.value.color }
  println("sequence is lazy, so it hasn't been evaluated yet")
  println("sequence values: " + sequence.toList())

  println("Name examples")
  val names = listOf("Joe", "Mary", "Jane")
  val nameFilter = { v: String -> println("Filtering $v"); v[0] == 'J' }
  val nameMap = { v: String -> println("Mapping $v"); v.toUpperCase() }
  val nameFind = { v: String -> v.endsWith("E") }

  println("collection example")
  println("toList")
  names.filter(nameFilter).map(nameMap).toList()
  println("find")
  names.filter(nameFilter).map(nameMap).find(nameFind)

  println("sequence example")
  println("toList")
  names.asSequence().filter(nameFilter).map(nameMap).toList()
  println("find")
  names.asSequence().filter(nameFilter).map(nameMap).find(nameFind)

}