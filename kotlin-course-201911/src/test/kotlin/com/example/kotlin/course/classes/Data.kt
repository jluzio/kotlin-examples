package com.example.kotlin.course.classes

// only primary constructor properties are used in toString/equals/hashCode
data class DataEmployee(val firstName: String, val surname: String) {

  var age: Int? = null

  fun toStringAllProps() = "${toString()}[age=$age]"
}

fun main() {
  val emp = DataEmployee("fn", "ln").apply { age = 32 }
  val emp2 = DataEmployee("fn", "ln").apply { age = 33 }
  println(emp)
  println(emp2)
  println(emp.toStringAllProps())
  println(emp2.toStringAllProps())
  println(emp == emp2)
  println(emp.copy().toStringAllProps())
}