package org.example.kotlin.playground

import org.example.kotlin.playground.extensions.prevLastIndex
import org.example.kotlin.playground.extensions.removeNegativeValues
import org.example.kotlin.playground.extensions.toStringNull
import org.junit.Test

class ExtensionsTest {
    @Test
    fun extension_function() {
        val list = listOf(1, -2, 3, -4, 5)
        val positiveList = list.removeNegativeValues()
        println(positiveList)
        println(positiveList.toStringNull())
        println(positiveList.prevLastIndex)
    }
}