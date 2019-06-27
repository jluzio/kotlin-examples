package org.example.kotlin.playground

import org.junit.Test
import java.time.LocalDate

data class Customer(val name: String, val email: String)
data class MutableCustomer(var name: String, var email: String)

class IdiomsTest {
    @Test
    fun dtos() {
        var c1 = Customer("name1", "email1")
        println(c1)
        var c2 = MutableCustomer("name2", "email2")
        println(c2)
    }

    @Test
    fun default_values() {
        fun foo(a: Int = 0, b: String = "") {
            // ...
        }

        val list = listOf(-1, 2, -3, 4)
        val positives1 = list.filter { x -> x > 0 }
        val positives2 = list.filter { it > 0 }
    }

    @Test
    fun list_filter() {
        var list = listOf(0, -1, 2, -3, 4)
        val positives1 = list.filter { x -> x > 0 }
        println(positives1)
        val positives2 = list.filter { it > 0 }
        println(positives2)
    }

    @Test
    fun string_interpolation() {
        var name = "John"
        println("Name $name")
    }

    @Test
    fun instance_check() {
        var x: Any = ""
        when (x) {
            is String -> println("is String")
            is LocalDate -> println("is LocalDate")
            else -> println("is Unknown")
        }
    }

    @Test
    fun traversing_map_list_pairs() {
        println("map")
        var map = mapOf(1 to "x", 2 to "y", -1 to "zz")
        for ((k, v) in map) {
            println("$k -> $v")
        }
        var listOfPairs = listOf(1 to "x", 2 to "y", -1 to "zz")
        println("listOfPairs")
        for ((k, v) in listOfPairs) {
            println("$k -> $v")
        }
    }
}