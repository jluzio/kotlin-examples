package com.example.kotlin.course.collections

typealias Car = DestructurableCar

fun main() {
    val immutableMap = mapOf(
        1 to Car("green", "Toyota", 2012),
        2 to Car("red", "Ford", 2013),
        3 to Car("blue", "BMW", 2014))

    println("map class: ${immutableMap.javaClass} | map: $immutableMap")

    val mutableMap = immutableMap.toMutableMap()
    println("map class: ${mutableMap.javaClass} | map: $mutableMap")

    immutableMap.forEach { (key, value) -> println("Iter :: key: $key | car: $value")}
    for ((k, v) in immutableMap) {
        println("k: $k | v: $v")
    }

}