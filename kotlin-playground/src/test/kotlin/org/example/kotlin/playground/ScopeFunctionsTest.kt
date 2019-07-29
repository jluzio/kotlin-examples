package org.example.kotlin.playground

import org.junit.Test

class ScopeFunctionsTest {
    data class Person(var firstName: String = "", var surname: String = "")

    @Test
    fun let_run_test() {
        var letFun = { o: Any -> "has_data: " + o.toString() }
        val data: String? = "--data--"
        val isNull: String? = null
        println("-- let --")
        println(data?.let { letFun(it) })
        println(isNull?.let { letFun(it) })
        println("-- run --")
        println(isNull?.run { letFun(this) })
    }

    @Test
    fun with_test() {
        val johnDoe = Person("John", "Doe")
        println("PersonAttrs:")
        with (johnDoe) {
            println(firstName)
            println(surname)
        }
    }

    @Test
    fun apply_test() {
        val jake = Person().apply {
            firstName = "Jake"
            surname = "Doe"
        }
        println(jake.toString())
    }

    @Test
    fun also_test() {
        val jake = Person("Jake", "Doe").also(::println)
    }
}