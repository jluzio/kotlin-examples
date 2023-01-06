package com.example.kotlin.maven.playground

import com.example.kotlin.maven.playground.model.BarBean
import org.junit.jupiter.api.Test

class MixedLangTest {

  @Test
  fun test() {
    println(BarBean())
    println(com.example.kotlin.maven.playground.java.model.FooBean())

    listOf(1, 2, 3).forEach { v -> println("number: $v") }
  }
}