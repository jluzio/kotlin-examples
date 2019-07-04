package org.example.kotlin.playground

import org.junit.Test

class ParametersTest {

    @Test
    fun default_value_parameters() {
        fun add(a: Int = 1, b: Int, c: Int = 3):Int { return a + b + c }
        println(add(-1,2))
        println(add(-1,2, -1))
    }

    @Test
    fun named_parameters() {
        fun add(a: Int = 1, b: Int, c: Int = 3):Int { return a + b + c }
        println(add(-1,2))
        println(add(b = 2))
    }

}