package org.example.kotlin.playground

import org.junit.Test
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException

class MiscTest {
    @Test
    fun static_call() {
        println(String::class)
    }

    @Test
    @Throws(IllegalArgumentException::class, UnsupportedOperationException::class)
    fun declare_exception() {
        throw IllegalArgumentException("test")
    }

}