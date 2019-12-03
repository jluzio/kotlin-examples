package com.example.kotlin.course.generics

fun main() {
    val cars = mutableListOf(Car(), Car())
    val toyotas = mutableListOf(Toyota(), Toyota())
    val fords = mutableListOf(Ford(), Ford())

    val carsOutput = mutableListOf<Car>()
    copyCars(cars, carsOutput)

    val toyotasOutput = mutableListOf<Toyota>()
//    copyCars(toyotas, toyotasOutput) // error

    val mixedCarsOutput = mutableListOf<Car>()
    copyCarsGeneric(cars, mixedCarsOutput)
    copyCarsGeneric(toyotas, mixedCarsOutput)
    copyCarsGeneric(fords, mixedCarsOutput)

}

fun copyCars(source: MutableList<Car>, target: MutableList<Car>) {
    for (c in source) {
        target.add(c)
    }
}

fun <T: Car> copyCarsGeneric(source: MutableList<out T>, target: MutableList<T>) {
    for (c in source) {
        target.add(c)
    }
}

open class Car {}
class Toyota: Car() {}
class Ford: Car() {}
