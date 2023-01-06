package com.example.kotlin.playground

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class LogTest {

  val log = LoggerFactory.getLogger(LogTest::class.java)

  @Test
  fun test() {
    log.debug("test log")
  }
}