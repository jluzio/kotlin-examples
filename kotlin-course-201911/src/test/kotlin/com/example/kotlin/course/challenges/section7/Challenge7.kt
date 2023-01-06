package com.example.kotlin.course.challenges.section7

fun main() {
  val joe = Person("Joe", "Jones", 45)
  val jane = Person("Jane", "Smith", 12)
  val mary = Person("Mary", "Wilson", 70)
  val john = Person("John", "Adams", 32)
  val jean = Person("Jean", "Smithson", 66)

  val (fName, lName, age) = joe
  println("fName = $fName, lName = $lName, age = $age")

  val mapPersonByLastname = listOf(joe, jane, mary, john, jean).associateBy { it.lastName }
  println(mapPersonByLastname)

  println(
    "count[s] = ${
      mapPersonByLastname.values.count {
        it.lastName.toUpperCase().startsWith("S")
      }
    }"
  )

  println(mapPersonByLastname.values.map { Pair(it.firstName, it.lastName) })
  // other option
  val firstNames = mapPersonByLastname.map { it.value.firstName }
  val lastNames = mapPersonByLastname.map { it.value.lastName }
  println(firstNames.zip(lastNames))

  val list1 = listOf(1, 4, 9, 15, 33)
  val list2 = listOf(4, 55, -83, 15, 22, 101)
  println(list1.intersect(list2).toList())
  println(list1.filter { it in list2 })

  val regularPaper = Box<Regular>()
  var paper = Box<Paper>()
  paper = regularPaper

}

class Person(val firstName: String, val lastName: String, val age: Int) {

  operator fun component1() = firstName
  operator fun component2() = lastName
  operator fun component3() = age
}

class Box<out T> {
}

open class Paper {
}

class Regular : Paper() {
}

class Premium : Paper() {
}