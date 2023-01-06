package com.example.kotlin.course.generics

fun main() {
  val floats = listOf(1.2f, 2.3f, 3.4f)
  val shorts = listOf(1, 2, 3)
  val strings = listOf("a", "b", "c")

  println("converts")
  convertToInt(shorts)
  convertToInt(floats)
  // convertToInt(strings) // err

  println("appends")
  append(StringBuilder("asd"), StringBuilder("123"))

  println("simple type check for generics works with Kotlin even with type erasure")
  if (strings is List<String>) println("strings")
  if (strings is List<Any>) println("any")
  println("type checks that rely on runtime info don't work because of type erasure")
  // if (strings is List<Int>) println("int") // error

  val listAny: List<Any> = strings
  //if (listAny is List<String>) println("strings") // error
  if (listAny is List<*>) println("is list")

}

fun <T : Number> convertToInt(collection: List<T>) {
  collection.forEach { println(it.toInt()) }
}

fun <T> append(seq1: T, seq2: T)
    where T : CharSequence, T : Appendable {
  println("Append: ${seq1.append(seq2)}")
}