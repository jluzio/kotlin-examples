package org.example.kotlin.playground

import org.junit.Test

class CollectionsTest {

    @Test
    fun readonly_collections() {
        var list = listOf(1, 2, 3)
        var set = setOf(1, 2, 3)
        var map = mapOf(1 to "a", 2 to "b")
        println("collections: $list | $set | $map")
        println("map.1: ${map[1]}")
    }

    @Test
    fun mutable_collections() {
        var list = mutableListOf(1, 2, 3)
        var set = mutableSetOf(1, 2, 3)
        var map = mutableMapOf(1 to "a", 2 to "b")

        list.add(4)
        map[1] = "33"

        println("collections: $list | $set | $map")
        println("map.1: ${map[1]}")

    }

    interface Foo { fun foo() }
    interface FooBar: Foo { fun bar() }
    class FooBarImpl: FooBar {
        override fun foo() {
            println("foo")
        }
        override fun bar() {
            println("bar")
        }
    }

    @Test
    fun covariant_test() {
        fun receivesListFoo(foos: List<Foo>) {
            println("foos: $foos")
        }
        var list : List<FooBar> = listOf(FooBarImpl())
        receivesListFoo(list)
    }

    @Test
    fun list_structural_equality() {
        data class Person(val name: String, var age: Int)
        val list1 = listOf(Person("Adam", 30), Person("Bob", 30))
        val list2 = listOf(Person("Adam", 30), Person("Bob", 40))

        println("eq: ${list1 == list2}")

        // using lambda without parenthesis on forEach
        list2.forEach {
            it.age = 30
        }
        println("eq: ${list1 == list2}")
    }
}