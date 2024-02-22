package com.example.kotlin.playground.testing

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Asserts from kotlin-test
 */
class AssertTest {

  val testSample = BasicTestSample()

  @Test
  fun test() {
    val expected = 42
    assertEquals(expected, testSample.sum(40, 2))
  }

}