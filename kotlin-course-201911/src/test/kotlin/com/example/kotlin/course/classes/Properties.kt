package com.example.kotlin.course.classes

class PropEmployee(name: String) {

  var name = name
    get() = field
    set(value) {
      field = value
    }
}

class GetterSetterBean() {

  var name: String? = null
    set(value) {
      println("setter"); field = value
    }
}

fun main() {
  val gs = GetterSetterBean()
  println(gs.name)
  gs.name = "1"
  println(gs.name)
}