package org.example.kotlin.playground

import org.junit.Test

fun log(message: Any?) {
    println(message)
}

class BasicSyntaxTest {
    fun sum(a: Int, b: Int) = a + b
    fun maxOf(a: Int, b: Int) = if (a > b) a else b

    @Test
    fun test() {
        log("sum: ${sum(1, 2)}")

        val constant = 123
        log("const: $constant")

        val toInitConst: Int
        toInitConst = 3
        log("const: $toInitConst")

        // String templates
        var a = 1
        // simple name in template:
        val s1 = "a is $a"

        a = 2
        // arbitrary expression in template:
        val s2 = "${s1.replace("is", "was")}, but now is $a"
        log("str templates: $s1 | $s2")

        log("maxOf: ${maxOf(1, 2)}")
    }

    @Test
    fun nullableFun() {
        fun canReturnNull(str: String): Int? = str.toIntOrNull()
        fun canReceiveNullAndReturnNull(str: String?): Int? = str?.toIntOrNull()

        log("null params (S)")
        log(canReturnNull("32"))
        log(canReceiveNullAndReturnNull("32"))
        log(canReceiveNullAndReturnNull(null))
        log("null params (E)")

        // nullable calls
        log("nullable calls (S)")
        val a = "Kotlin"
        val b: String? = null
        log(a?.length) // Unnecessary safe call
        log(b?.length)
        log(b?.length ?: -1)
        log("nullable calls (E)")

        // safe cast
        val aInt: Int? = a as? Int
        log("safe cast: $aInt")

        val nullableList: List<Int?> = listOf(1, 2, null, 4)
        val intList: List<Int> = nullableList.filterNotNull()
        log("filtered non null list $intList")
        log("filtered non null list ${nullableList.filter { v -> v != null }}")
    }

    @Test
    fun typeChecks_automaticCasts() {
        fun objLen1(obj: Any?): Int {
            if (obj is String) {
                return obj.length
            }
            return 0
        }

        fun objLen2(obj: Any): Int {
            if (obj !is String) {
                return 0
            }
            return obj.length
        }

        val obj1 = "1234"
        val obj2 = null
        log("len1_1: ${objLen1(obj1)}")
        log("len1_2: ${objLen2(obj1)}")
        log("len2_1: ${objLen1(obj2)}")
        log("len2_2: ${objLen1(obj2)}")
    }

    @Test
    fun loops() {
        for (value in listOf(1, 2, 3)) {

        }
    }

    @Test
    fun while_test() {
        fun describe(obj: Any): String =
                when (obj) {
                    1 -> "One"
                    "Hello" -> "Greeting"
                    is Long -> "Long"
                    !is String -> "Not a string"
                    else -> "Unknown"
                }
        log("describe1: ${describe("Hello")}")
        log("describe2: ${describe("asd")}")
        log("describe3: ${describe(13)}")
    }

    @Test
    fun range() {
        val x = 10
        val y = 9
        if (x in 1..y + 1) {
            log("fits in range")
        }

        val list = listOf("a", "b", "c")

        if (-1 !in 0..list.lastIndex) {
            println("-1 is out of range")
        }
        if (list.size !in list.indices) {
            println("list size is out of valid list indices range, too")
        }

        for (x in 1..5) {
            print(x)
        }
        println()

        for (x in 1..10 step 2) {
            print(x)
        }
        println()

        for (x in 9 downTo 0 step 3) {
            print(x)
        }
        println()
    }

    @Test
    fun collections() {
        val items = listOf("banana", "avocado", "apple", "kiwifruit")
        when {
            "orange" in items -> println("juicy")
            "apple" in items -> println("apple is fine too")
        }

        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits
                .filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }
    }

}