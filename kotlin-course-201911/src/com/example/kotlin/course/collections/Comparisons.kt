package com.example.kotlin.course.collections

fun main() {
    val colorFun = { v: Int ->
        when(v % 4) { 0 -> "Red"; 1 -> "Green"; 2 -> "Black" else -> "Blue"; }
    }
    val modelFun = { v: Int ->
        when(v % 3) { 0 -> "Toyota"; 1 -> "Opel"; else -> "Renault"; }
    }
    val cars = (0..10).map { DataCar(colorFun(it), modelFun(it), 2000 + it) }
    println(cars)

    val sortedCars = cars.sortedWith(
        compareBy<DataCar>(
            { it.model },
            { it.color },
            { it.year }
        )
    )
    sortedCars.forEach(::println)
}