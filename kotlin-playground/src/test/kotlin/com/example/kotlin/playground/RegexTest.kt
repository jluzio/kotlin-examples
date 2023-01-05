package com.example.kotlin.playground

import com.google.common.base.Strings
import com.example.kotlin.playground.helper.LogDelegate
import org.junit.jupiter.api.Test

class RegexTest {

  val log by com.example.kotlin.playground.helper.LogDelegate()

  @Test
  fun test() {
    val header = { pattern: String, separator: String ->
      log.debug("{} {} {}", Strings.repeat(separator, 40), pattern, Strings.repeat(separator, 40))
    }

    val patterns = listOf(
      """^[\w\s-]+$""",
      """^\p{L}+$""",
      """^[\p{L} -\.:]+$""",
    )
      .map { it.toRegex() }
    val values = listOf(
      "john",
      "John",
      "José",
      "John Doe",
      "José Doe",
      "José Doe - Mr",
      "/john/i",
    )

    patterns.forEach { pattern ->
      header(pattern.toString(), "-")
      values.forEach { log.debug("{} :: {}", it, pattern.matches(it)) }
      header(pattern.toString(), "=")
    }
  }
}