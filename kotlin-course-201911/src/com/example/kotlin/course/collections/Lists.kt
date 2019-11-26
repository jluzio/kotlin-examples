package com.example.kotlin.course.collections

fun main() {
    val strings = listOf("a", "b", "ccc")
    println(strings.javaClass)

    val emptyList = emptyList<String>()
    println(emptyList.javaClass)

    val notNullList = listOfNotNull("abc", null, "cba")
    println(notNullList)
    println(notNullList[0])

    val mutable = mutableListOf("aaa")
    mutable[0] = "bbb"
    println(mutable)
    mutable += "ccc"
    println(mutable)

    println("types")
    println(listOf("aaa").javaClass)
    println(listOf("aaa", "bbb").javaClass)
    println(mutableListOf("aaa").javaClass)
    println(arrayListOf("aaa").javaClass)

    println(arrayOf("aaa").toList().javaClass)

}