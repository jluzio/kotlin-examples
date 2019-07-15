package org.example.kotlin.playground

import org.junit.Test

class FunctionTest {

    private infix fun String.infix_concat_print(value: String) {
        println(this + value)
    }

    @Test
    fun infix_test() {
        "Left ".infix_concat_print("Right")
        "Left " infix_concat_print "Right"
    }

}