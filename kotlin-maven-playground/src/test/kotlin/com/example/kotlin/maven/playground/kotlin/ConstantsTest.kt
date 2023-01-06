package com.example.kotlin.maven.playground.kotlin

import com.example.kotlin.maven.playground.java.model.SomeAnnotation
import com.example.kotlin.maven.playground.model.CONST_VAL
import com.example.kotlin.maven.playground.model.Constants
import org.junit.jupiter.api.Test

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