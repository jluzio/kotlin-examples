package org.example.kotlin.core.kotlin

import org.junit.Test

class MixedLangTest {

    @Test
    fun test() {
        println(org.example.kotlin.core.kotlin.model.BarBean())
        println(org.example.kotlin.core.java.model.FooBean())

        listOf(1, 2, 3).forEach { v -> println("number: $v" ) }
    }
}