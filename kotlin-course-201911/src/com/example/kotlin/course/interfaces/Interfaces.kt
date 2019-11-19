package com.example.kotlin.course.interfaces

fun main() {
    val foo = Foo("bar1")
    foo.barPrint()
    foo.run { println("bar: $bar | foo_bar: $foo_bar") }
}

interface IFoo {
    val bar: String
    val foo_bar: String
    get() = "foo$bar"
    fun barPrint()
}

class Foo(bar: String): IFoo {
    override val bar: String = bar
    override fun barPrint() = println(bar)
}

class Foo2(override val bar: String): IFoo {
    override fun barPrint() = println(bar)
}