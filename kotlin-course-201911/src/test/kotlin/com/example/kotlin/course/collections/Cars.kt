package com.example.kotlin.course.collections

class NonDestructurableCar(val color: String, val model: String, val year: Int)
class DestructurableCar(val color: String, val model: String, val year: Int) {

  operator fun component1() = color
  operator fun component2() = model
  operator fun component3() = year
}

data class DataCar(val color: String, val model: String, val year: Int)
