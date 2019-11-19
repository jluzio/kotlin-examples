package com.example.kotlin.course.interfaces

interface IFoo {
    val bar: String
    fun barPrint()
}

class Foo(bar: String): IFoo {
    override val bar: String = bar
    override fun barPrint() = println(bar)
}

class Foo2(override val bar: String): IFoo {
    override fun barPrint() = println(bar)
}