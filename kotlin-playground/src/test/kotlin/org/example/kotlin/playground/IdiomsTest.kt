package org.example.kotlin.playground

import org.junit.Assert
import org.junit.Test
import java.io.File
import java.time.LocalDate

class IdiomsTest {
    data class Customer(val name: String, val email: String)
    data class MutableCustomer(var name: String, var email: String)

    @Test
    fun dtos() {
        var c1 = Customer("name1", "email1")
        println(c1)
        var c2 = MutableCustomer("name2", "email2")
        println(c2)
    }

    @Test
    fun default_values() {
        fun foo(a: Int = 0, b: String = "") {
            // ...
        }

        val list = listOf(-1, 2, -3, 4)
        val positives1 = list.filter { x -> x > 0 }
        val positives2 = list.filter { it > 0 }
    }

    @Test
    fun list_filter() {
        var list = listOf(0, -1, 2, -3, 4)
        val positives1 = list.filter { x -> x > 0 }
        println(positives1)
        val positives2 = list.filter { it > 0 }
        println(positives2)
    }

    @Test
    fun string_interpolation() {
        var name = "John"
        println("Name $name")
    }

    @Test
    fun instance_check() {
        var x: Any = ""
        when (x) {
            is String -> println("is String")
            is LocalDate -> println("is LocalDate")
            else -> println("is Unknown")
        }
    }

    @Test
    fun traversing_map_list_pairs() {
        println("map")
        var map = mapOf(1 to "x", 2 to "y", -1 to "zz")
        for ((k, v) in map) {
            println("$k -> $v")
        }
        var listOfPairs = listOf(1 to "x", 2 to "y", -1 to "zz")
        println("listOfPairs")
        for ((k, v) in listOfPairs) {
            println("$k -> $v")
        }
    }

    @Test
    fun using_ranges() {
        var list1 = ArrayList<Int>()
        var list2 = ArrayList<Int>()
        var list3 = ArrayList<Int>()
        var list4 = ArrayList<Int>()

        for (i in 1..100) {
            list1.add(i)
        }  // closed range: includes 100
        for (i in 1 until 100) {
            list2.add(i)
        } // half-open range: does not include 100
        for (x in 2..10 step 2) {
            list3.add(x)
        }
        for (x in 10 downTo 1) {
            list4.add(x)
        }
        if (5 in 1..10) {
            println("is in 1..10")
        }

        println("list1: $list1")
        println("list2: $list2")
        println("list3: $list3")
        println("list4: $list4")
    }

    @Test
    fun read_only_collections() {
        val list = listOf("a", "b", "c")
        val map = mapOf("a" to 1, "b" to 2, "c" to 3)
        val mutable_list = ArrayList(listOf("a", "b", "c"))

        // list.add does not exist
        mutable_list.add("d")

        println(list)
        println(map)
        println(mutable_list)
    }


    @Test
    fun map() {
        val map = HashMap(mapOf("a" to 1, "b" to 2, "c" to 3))
        println(map["a"])
        map["a"] = 5
        println(map["a"])
    }

    @Test
    fun lazy_property() {
        val lazyProp: String by lazy {
            // compute the string
            println("Compute")
            "test" + "-" + "val"
        }
        println("Lazy Prop")
        println(lazyProp)
        println(lazyProp)
    }

    @Test
    fun extensions() {
        fun String.spaceToCamelCase(): String { return "CaMelCaSe" }

        println("Convert this to camelcase".spaceToCamelCase())
    }

    object SingletonBean {
        val name = "Name"
    }
    @Test
    fun singleton() {
        println(SingletonBean.name)
    }

    @Test
    fun ifNotNullShorthand() {
        val files = File("Test").listFiles()
        // If not null shorthand
        println(files?.size)
        // If not null and else shorthand
        println(files?.size ?: "empty")
    }

    @Test
    fun ifNullExecute() {
        val values = mapOf("name" to "name of x", "not_email" to 6)
        try {
            val name = values["name"] ?: throw IllegalStateException("Name is missing!")
            println(name)
        } catch (e: Exception) {
            Assert.fail("not expected")
        }
        try {
            val email = values["email"] ?: throw IllegalStateException("Email is missing!")
            println(email)
            Assert.fail("not expected")
        } catch (e: Exception) {
            // expected
        }
    }

    @Test
    fun firstOfPossibleEmptyCollection() {
        var emails : Collection<String>
        emails = listOf()
        println("value: '${emails.firstOrNull() ?: ""}'")
        emails = listOf("not-null!")
        println("value: '${emails.firstOrNull() ?: ""}'")
    }

    @Test
    fun execute_if_not_null() {
        val value = null

        value?.let {
            println("not null value")
        }
        println("value: $value")
    }

    @Test
    fun map_nullable_value_if_not_null() {
        // TODO
    }

}