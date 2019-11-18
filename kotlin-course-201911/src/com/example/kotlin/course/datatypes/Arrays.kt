package com.example.kotlin.course.datatypes

import com.example.kotlin.course.javacode.JavaClass

fun main() {
    println(Array(10) { it * 2 }.toList())

    val intClassArray = arrayOf(1, 2, 3)
    val intPrimitiveArray = intArrayOf(1, 2, 3)

    // Error
//    JavaClass().printIntArray(intClassArray)
    JavaClass().printIntArray(intPrimitiveArray)
    JavaClass().printIntArray(intClassArray.toIntArray())

    // -> Array<Int>
    println(intPrimitiveArray.toTypedArray())
}