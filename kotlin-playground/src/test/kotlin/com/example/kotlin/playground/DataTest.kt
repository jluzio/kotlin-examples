package com.example.kotlin.playground

import org.junit.jupiter.api.Test

class DataTest {

  data class Message(val text: String = "")
  object SingletonMessage {
    var text: String = "<unset>"

    override fun toString() = "${this.javaClass.simpleName}(text=$text)"
  }

  @Test
  fun test() {
    println(Message("msg1"))
    println(Message("msg2"))
    println(SingletonMessage)
    SingletonMessage.text = "test"
    println(SingletonMessage)
  }

}