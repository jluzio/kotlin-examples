package com.example.kotlin.playground

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test


class ConversionToJavaTypesTest {


  @Test
  fun test() {
    val kotlinList = listOf("1", "2", "3")

    val immutableJavaList = kotlinList as java.util.List<String>
    assertThat(immutableJavaList)
      .isEqualTo(java.util.List.of("1", "2", "3"))
    assertThatThrownBy { immutableJavaList.add("4") }
      .isInstanceOf(UnsupportedOperationException::class.java)

    val mutableJavaList = kotlinList.toMutableList() as java.util.List<String>
    assertThat(mutableJavaList)
      .isEqualTo(java.util.List.of("1", "2", "3"))
    assertThatCode { mutableJavaList.add("4") }
      .doesNotThrowAnyException()
  }

}