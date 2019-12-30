package org.example.kotlin.core.kotlin

import org.junit.Test

class Java6Test {

    @Test
    fun test() {
        val comparator = Comparator<Int> { v1, v2 -> v1 - v2 }.reversed()
        println(listOf(2, 4, 5, 2, 8).sortedWith(comparator))
    }

}