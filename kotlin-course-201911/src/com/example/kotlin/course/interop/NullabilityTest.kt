package com.example.kotlin.course.interop

import org.apache.logging.log4j.LogManager
import org.junit.Test
import java.lang.Exception

class NullabilityTest {
    var log = LogManager.getLogger(javaClass)

    @Test
    fun test1() {
        log.warn("testing")
        var bean = JavaBean()
        val someVal = bean.value
        bean.value = null
        bean.nullableValue = null
        try {
            bean.nonNullableValue = null
        } catch (e: Exception) {
          log.debug("Expected exception thrown: {}", e.message)
        }
        log.debug(bean.value.javaClass)

        val x: String? = null
        // can't print T?.javaClass, because it's kotlin exclusive
        // log.debug(x.javaClass)

    }
}
