package com.example.kotlin.course.interop

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class NullabilityTest {

  var log = LoggerFactory.getLogger(javaClass)

  @Test
  fun test1() {
    log.warn("testing")
    val bean = JavaBean()
    val someVal = bean.value
    bean.value = null
    bean.nullableValue = null
    try {
      bean.nonNullableValue = null
    } catch (e: Exception) {
      log.debug("Expected exception thrown: {}", e.message)
    }
    log.debug("{}", bean.value?.javaClass)

    val x: String? = null
    // can't print T?.javaClass, because it's kotlin exclusive
    // log.debug(x.javaClass)

  }
}
