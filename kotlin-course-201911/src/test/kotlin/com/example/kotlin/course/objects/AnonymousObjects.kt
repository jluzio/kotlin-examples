package com.example.kotlin.course.objects

fun main() {
  // this object is not singleton, and its discarded after execution
  acceptsFoo(object : AnonFoo {
    override fun bar(): String = "anon_foo_42"
  })
}

interface AnonFoo {

  fun bar(): String
}

fun acceptsFoo(foo: AnonFoo) {
  println("foo.bar: ${foo.bar()}")
}
