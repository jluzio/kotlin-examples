package com.example.kotlin.playground.kotlinx.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.slf4j.LoggerFactory
import kotlin.test.Test

class ChannelTest {
  val log = LoggerFactory.getLogger(this::class.java)

  @Test
  fun channel_types() {
    val rendezvousChannel = Channel<String>()
    val bufferedChannel = Channel<String>(10)
    val conflatedChannel = Channel<String>(CONFLATED)
    val unlimitedChannel = Channel<String>(UNLIMITED)
  }

  @Test
  fun testChannelSimple() = runTest {
    val channel = Channel<String>()
    launch {
      channel.send("A1")
      channel.send("A2")
      log.info("A done")
    }
    launch {
      channel.send("B1")
      log.info("B done")
    }
    launch {
      repeat(3) {
        val message = channel.receive()
        log.info(message)
      }
    }
  }

}