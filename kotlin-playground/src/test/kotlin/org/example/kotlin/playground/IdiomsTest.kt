package org.example.kotlin.playground

import org.junit.Test

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
}