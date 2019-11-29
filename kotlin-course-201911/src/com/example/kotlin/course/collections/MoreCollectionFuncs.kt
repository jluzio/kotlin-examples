package com.example.kotlin.course.collections

fun main() {
    val setInts = setOf(1, 4, 3)
    println(setInts.filter { it % 2 == 0 })

    println(setInts.map { it + 10 })

}