package org.example.kotlin.playground

import org.junit.Test

class OperatorOverloadingTest {

    data class MyNumber(val value: String) {
        operator fun plus(other: String): MyNumber {
            val intSum = value.toInt() + other.toInt()
            return MyNumber(intSum.toString())
        }
        operator fun plus(other: MyNumber): MyNumber {
            return plus(other.value)
        }
    }

    @Test
    fun test_MyNumber_plus() {
        val n1 = MyNumber("1")
        val n2 = n1 + "2"
        val n3 = n2 + MyNumber("3")
        println("values: $n1 | $n2 | $n3")
    }

}