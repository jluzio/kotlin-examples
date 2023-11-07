package com.example.kotlin.playground

import com.example.kotlin.playground.helper.LogDelegate
import com.example.kotlin.playground.java.JavaData
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test


class ConversionToJavaTypesTest {

  val log by LogDelegate()

  @Test
  fun lists() {
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

  @Test
  fun javaInteraction() {
    val javaData = JavaData.builder()
      .stringList(listOf("1", "2"))
      .stringArray(arrayOf("1", "2"))
      .build()
    log.info("javaData: $javaData")
    log.info("stringList.class: ${javaData.stringList.javaClass}")
    log.info("stringArray.class: ${javaData.stringArray.javaClass}")

    assertThatThrownBy { javaData.stringList.add("3") }
      .isInstanceOf(UnsupportedOperationException::class.java)
    assertThat(javaData.stringArray)
      .isInstanceOf(Array<String>::class.java)

    assertThat(javaData.equalsToStringArray(*arrayOf("1")))
      .isFalse()
    assertThat(javaData.equalsToStringArray(*arrayOf("1", "2")))
      .isTrue()
  }

}