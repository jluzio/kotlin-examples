package com.example.kotlin.playground.testing

import org.junit.jupiter.api.assertDoesNotThrow
import org.slf4j.LoggerFactory
import strikt.api.expect
import strikt.api.expectThat
import strikt.assertions.*
import kotlin.test.Test


class StriktLibTest {

  val log = LoggerFactory.getLogger(this::class.java)
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
        .hasLength(5)
        .isLowerCase()
      that(1L) {
        isLessThanOrEqualTo(1L).isA<Long>()
        isGreaterThanOrEqualTo(1L)
      }
    }
  }

  @Test
  fun checkErrorReportingFormat() {
    try {
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
    } catch (t: Throwable) {
      // encoding of message gets messed up compared to when the exception is handled by the test framework
      System.err.println(t.message)
    }
  }

}