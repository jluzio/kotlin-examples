package com.example.kotlin.course.exceptions

import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun main() {
    println("""parse: ${parseNumber("20")}""")
    println("""parse: ${parseNumber("asd")}""")
    val parse1 = try { Integer.parseInt("asd") } catch (e: Exception) { null }
    val parse2 = try { Integer.parseInt("asd") } catch (e: Exception) { }

    val val_is_nothing = failFunc()
    val val_is_unit = failFunc2()
    val_is_unit.runCatching {  }
}

fun parseNumber(str: String): Int {
    return try {
        Integer.parseInt(str)
    }
    catch (e: NumberFormatException) {
        0
    }
    finally {
        println("finally")
    }
}

// declare that function doesn't return a value or even unit
fun failFunc(): Nothing {
    throw IllegalArgumentException("Fail")
}

fun failFunc2() {
    throw IllegalArgumentException("Fail")
}