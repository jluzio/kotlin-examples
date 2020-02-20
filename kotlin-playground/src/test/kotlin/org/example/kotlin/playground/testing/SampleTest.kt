package org.example.kotlin.playground.testing

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test

class SampleTest {
    open class Hello() {
        open fun sayHello(target: String) = "Hello $target!"
    }

    @Test
    fun test() {
        val mock = mock<Hello>()
        whenever(mock.sayHello(any())).thenReturn("Bamboozled")
        println(mock.sayHello("world"))
    }

}