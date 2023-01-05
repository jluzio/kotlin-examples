package com.example.kotlin.playground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
  runApplication<com.example.kotlin.playground.Application>(*args)
}
