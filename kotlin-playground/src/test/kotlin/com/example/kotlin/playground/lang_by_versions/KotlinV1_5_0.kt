package com.example.kotlin.playground.lang_by_versions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import kotlin.io.path.Path
import kotlin.io.path.div
import kotlin.io.path.listDirectoryEntries

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

  @Test
  fun unsigned_integer_types() {
    val unsignedInt1 = 42u
    val unsignedInt2: UInt = 42u
    log.debug("{}", mapOf("uInt1" to unsignedInt1, "uInt2" to unsignedInt2))
    log.debug("{}", mapOf("int.max" to Int.MAX_VALUE, "uint.max" to UInt.MAX_VALUE))
    assertThat(UInt.MAX_VALUE.toString()).isGreaterThan(Int.MAX_VALUE.toString())
  }

  @Test
  fun locale_agnostic_text_functions() {
    // replacing toUpperCase/toLowerCase/capitalize/decapitalize
    assertThat("asd".uppercase()).isEqualTo("ASD")
    assertThat("ASD".lowercase()).isEqualTo("asd")
    assertThat("asd".replaceFirstChar { it.uppercase() }).isEqualTo("Asd")
    assertThat("ASD".replaceFirstChar { it.lowercase() }).isEqualTo("aSD")
    // replacing toUpperCase/toLowerCase/toTitleCase
    assertThat('a'.titlecaseChar()).isEqualTo('A')
  }

  @Test
  fun char_to_integer_conversion() {
    log.debug("{}", 1.digitToChar())
    log.debug("{}", '1'.digitToInt())
  }

  @Test
  fun path_api() {
    val basePath = Path(".")
    val subPath = basePath / "src"
    subPath.listDirectoryEntries().forEach { log.debug("{}", it) }
  }

}