package com.example.kotlin.playground.kotlinx.serialization

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SerializationTest {

  @Serializable
  data class Data(val a: Int, val b: String)

  @Test
  fun testBasic() {
    val data = Data(42, "str")
    val json = Json.encodeToString(data)
    assertThat(json)
      .isEqualTo("""
        {"a":42,"b":"str"}
      """.trimIndent())

    val decodedData = Json.decodeFromString<Data>(json)
    assertThat(decodedData).isEqualTo(data)
  }
}