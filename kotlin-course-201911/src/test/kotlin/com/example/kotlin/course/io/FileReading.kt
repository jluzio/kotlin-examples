package com.example.kotlin.course.io

import java.io.File

fun main() {
  val packagePath: String = Thread.currentThread().contextClassLoader.getResource(
    "com.example.kotlin.course.io".replace(
      ".",
      "/"
    )
  ).path

  val lines = File("$packagePath/file01.txt").readLines()
  println(lines)

  val reader2 = File("$packagePath/file01.txt").reader()
  val lines2 = reader2.readLines()
  reader2.close()
  println(lines2)

  val lines3 = File("$packagePath/file01.txt").reader().use { it.readLines() }
  println(lines3)

  val lines4 = File("$packagePath/file01.txt").readText()
  println(lines4)

  File("$packagePath/file01.txt").forEachLine { println(it) }
  File("$packagePath/file01.txt").useLines { it.forEach { l -> println(l) } }

}