package com.example.kotlin.course.loops_ranges

fun main() {
    for (i in 1..5) {
        println(i)
    }

    for (i in 1 downTo 5) {
        println(i)
    }

    for (i in 1..5 step 2) {
        println(i)
    }

    for (i in 1 until 5) {
        println(i)
    }

    for (i in 'a'..'c') {
        println(i)
    }

    val strRange = "AAA".."CCC"
    println("CCCCC" in strRange)
    println("CCCCC" !in strRange)

    for (c in "abc") {
        println(c)
    }

    val seasons = arrayOf("spring", "summer", "fall", "winter")
    for (index in seasons.indices) {
        println(index)
    }
    for (index in seasons.indices) {
        println(index)
    }


    println("named loops")
    for (i in 1..3) {
        println("i=$i")
        jloop@ for (j in 4..6) {
            println("j=$j")
            for (k in 7..9) {
                println("k=$k")
                if (k == 8) {
                    break@jloop
                }
            }
        }
    }

}