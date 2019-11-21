package com.example.kotlin.course.objects

import java.time.format.DateTimeFormatter

fun main() {
    println(SomeClass.someVal)
    println(SomeClass.Companion.someVal)

    println(Foo.default())
    println(Foo.time())
    println(Foo.Factory.default())
    println(Foo.Factory.time())
}

class SomeClass {
    companion object {
        val someVal = "42"
    }
}

class Foo private constructor(val bar: String) {
    companion object Factory {
        fun default() = Foo("default-bar")
        fun time() = Foo(java.time.LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
    }

    override fun toString(): String {
        return "Foo(bar=$bar)"
    }
}