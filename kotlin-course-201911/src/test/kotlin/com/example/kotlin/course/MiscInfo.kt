package com.example.kotlin.course

fun main() {
  val v1 = "v1"
  val v2 = "v2"
  val v2_2 = "v2"
  println("$v1 == $v2")
  println("$v2 == $v2_2")
  println("$v1 === $v2")
  println("$v2 === $v2_2")

  val rawString = """c:\test\f.txt"""
  print(rawString)
  val varInRaw = "l4"
  val rawStringMultiline = """line1
                            |l2
                            l3
                            |$varInRaw
    """
  println(rawStringMultiline)
  println(rawStringMultiline.trimMargin())

  val intVal = 42
  val short: Short = intVal.toShort()

  val c1: Any = 123
  val c2: Unit // similar to void, but is a singleton
  val c3: Nothing
  // used when method doesn't return
  // Nothing has no instances. You can use Nothing to represent "a value that never exists": for example, if a function has the return type of Nothing, it means that it never returns (always throws an exception).

}
