package com.example.kotlin.course.collections

fun main() {
  val pair = Pair(1, "one")
  val (pairLeft, pairRight) = pair
  println("pair: $pair | left: $pairLeft | right: $pairRight")

  val c1 = DestructurableCar("red", "Ferrari", 2020)
  val c2 = NonDestructurableCar("red", "Ferrari", 2020)
  val c3 = DataCar("red", "Ferrari", 2020)

  val (c1_c, c1_m, c1_y) = c1

  // not possible
  // val (c2_c, c2_m, c2_y) = c2

  val (c3_c, c3_m, c3_y) = c3


}