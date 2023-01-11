package com.example.kotlin.playground.lang_by_versions

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class KotlinV1_5_0 {

  val log = LoggerFactory.getLogger(KotlinV1_5_0::class.java)

  @JvmRecord
  data class User(val name: String, val age: Int)

  @Test
  fun record_support() {
    val user = User("John Doe", 42);
    log.debug("{}", user)
  }

  sealed interface Polygon
  class Rectangle() : Polygon
  class Triangle() : Polygon

  @Test
  fun sealed_interfaces() {
    // when() is exhaustive: no other polygon implementations can appear
// after the module is compiled
    fun draw(polygon: Polygon) = when (polygon) {
      is Rectangle -> println("rectangle")
      is Triangle -> println("triangle")
    }
  }

}