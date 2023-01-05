package com.example.kotlin.playground

import org.junit.jupiter.api.Test

class SealedTest {

  sealed interface Error // has implementations only in same package and module
  sealed class IOError() : Error // extended only in same package and module
  open class WriteIOError() : Error // can be extended wherever it's visible
  open class ReadIOError() : Error // can be extended wherever it's visible

  @Test
  fun test() {
    val error: Error = WriteIOError()
    when (error) {
      is WriteIOError -> println("WriteIOError")
      is ReadIOError -> println("ReadIOError")
      // no else required
    }
  }

}