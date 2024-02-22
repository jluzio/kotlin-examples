package com.example.kotlin.playground.testing

import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldHaveLength
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.Test

class KotestLibTest {

  val testSample = BasicTestSample()

  @Test
  fun test() {
    testSample.sayHello()
      .shouldBe("Hello World!")
      .shouldHaveLength(12)
    assertDoesNotThrow {
      testSample.sayHello()
    }
  }

}