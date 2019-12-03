package com.example.kotlin.course.generics

fun main() {
    val shortList = listOf<Short>(1, 2, 3)
    val mShortList = mutableListOf<Short>(1, 2, 3)

    // Read-only Collections are covariant, but Mutable are invariant
    listConvert(shortList)
//    mutableListConvert(mShortList) // error


}

/*
- out: Out defines type variance, ie that a variant type can be use instead of the specified
- functions declare "in types", so they can clash if the type is covariant
 */

fun listConvert(values: List<Number>) = values.forEach { println(it.toInt()) }
fun mutableListConvert(values: MutableList<Number>) = values.forEach { println(it.toInt()) }

class InvariantGarden<T: Flower> {
    val flowers = mutableListOf<T>()

    fun pickFlower(i: Int) = flowers[i]
    fun addFlower(flower: T) { flowers += flower }
    fun isPresent(flower: T) = flowers.contains(flower)
}
class CovariantGarden<out T: Flower> {
    val flowers = listOf<T>()

    fun pickFlower(i: Int) = flowers[i]

    // can't use T in method param, in order to avoid scenarios like this one that would add a Flower from a different type
//    fun addFlower(flower: T) { flowers += flower }
    // note: private functions are allowed to use this
    private fun privateFlower(flower: T) { println(flowers); println(flower) }

    // since type is covariant, the in type in the function isn't allowed, except only using @UnsafeVariance in "safe scenarios"
    fun isPresent(flower: @UnsafeVariance T) = flowers.contains(flower)
}

open class Flower(val name: String = "") {}
class Rose(name: String = ""): Flower(name) {}
class Daisy(name: String = ""): Flower(name) {}

fun tendGarden(garden: InvariantGarden<Rose>) {
    println("Tending invariant garden")
}
fun tendGarden(garden: CovariantGarden<Rose>) {
    println("Tending covariant garden")
}