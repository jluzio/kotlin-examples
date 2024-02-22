package com.example.kotlin.playground.testing

import org.junit.jupiter.api.assertDoesNotThrow
import strikt.api.expect
import strikt.api.expectThat
import strikt.assertions.*
import kotlin.test.Test

class StriktLibTest {

  val testSample = BasicTestSample()

  @Test
  fun test() {
    expectThat(testSample.sayHello())
      .isEqualTo("Hello World!")
    expectThat(testSample.sayHello()) {
      isEqualTo("Hello World!")
      hasLength(12)
    }
    assertDoesNotThrow {
      testSample.sayHello()
    }

    expect {
      that("fnord")
        .isA<String>()
        .hasLength(1)
        .isUpperCase()
      that(1L) {
        isLessThan(1L).isA<Int>()
        isGreaterThan(1L)
      }
    }

  }

}