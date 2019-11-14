package org.example.kotlin.core.kotlin

import org.example.kotlin.core.java.model.SomeAnnotation
import org.example.kotlin.core.kotlin.model.CONST_VAL
import org.example.kotlin.core.kotlin.model.Constants
import org.junit.Test

class ConstantsTest {
    @SomeAnnotation(text = CONST_VAL)
    class SomeAnnotatedClass {
    }
    @SomeAnnotation(text = Constants.CONST_VAL)
    class SomeAnnotatedClass2 {
    }

    @Test
    fun compileTimeConstants() {
        println("annotation: ${SomeAnnotatedClass::class.java.getAnnotation(SomeAnnotation::class.java).text}")
        println("annotation2: ${SomeAnnotatedClass2::class.java.getAnnotation(SomeAnnotation::class.java).text}")
    }
}