package com.example.kotlin.playground.lang_by_versions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KotlinV1_4_0 {

  @Test
  fun trailing_commas() {
    val values = listOf(
      "1",
      "2",
      "3",
    )
    assertThat(values).contains("1", "2", "3")
  }

  @Test
  fun function_reference_default_argument_values() {
    fun foo(i: Int = 0): String = "$i!"

    fun apply(func: () -> String): String = func()

    println(apply(::foo))
  }
}