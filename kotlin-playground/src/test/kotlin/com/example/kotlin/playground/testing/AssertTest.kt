package com.example.kotlin.playground.testing

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Asserts from kotlin-test
 */
class AssertTest {

  @Test
  fun test() {
    assertEquals("1", "1")
  }

}