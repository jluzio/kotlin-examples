package com.example.kotlin.course.io

import java.io.DataInputStream
import java.io.EOFException
import java.io.FileInputStream

fun main() {
  val packagePath: String = Thread.currentThread().contextClassLoader.getResource(
    "com.example.kotlin.course.io".replace(
      ".",
      "/"
    )
  ).path
  val di = DataInputStream(FileInputStream("$packagePath/file02.bin"))
  var si: String

  try {
    while (true) {
      si = di.readUTF()
      println(si)
    }
  } catch (e: EOFException) {
  }
}