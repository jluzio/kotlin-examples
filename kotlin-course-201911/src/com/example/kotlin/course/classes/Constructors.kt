package com.example.kotlin.course.classes.constructors

class Employee1 constructor(name: String) {
    val name: String

    init {
        this.name = name
    }
}

class Employee2 constructor(name: String) {
    val name: String = name
}

class Employee3(val name: String) {
}

class Employee4 {
    val name: String

    // both are secondary constructors
    constructor(name: String) {
        this.name = name
    }

    constructor(name: String, msg: String) {
        this.name = name
        println(msg)
    }
}

// constructor allows visibility/annotations if needed
class Employee5 private constructor(val name: String) {
    constructor(firstName: String, surname: String) : this("$firstName $surname")
}

class Employee6 {
    val name: String
    val random: Int

    init {
        random = (Math.random() * 1000).toInt()
    }

    constructor(firstName: String, surname: String) {
        name = "$firstName $surname"
    }
    constructor(name: String) {
        this.name = name
    }

    override fun toString(): String {
        return "name: $name | random: $random"
    }
}

open class User(val name: String) {
    constructor(firstName: String, surname: String): this("$firstName $surname")
}
// secondary constructor using super primary constructor
class User2(name: String): User(name) {
    constructor(firstName: String, surname: String): this("$firstName $surname") {
    }
}
// usage of super secondary constructor allowed if no secondary constructor exists
class User3(firstName: String, surname: String): User(firstName, surname)
// to define secondary constructor, don't declare primary constructor
class User4: User {
    constructor(firstName: String, surname: String): super(firstName, surname) {
    }
}

fun main() {
    println(Employee1("e1").name)
    println(Employee2("e2").name)
    println(Employee3("e3").name)
    println(Employee4("e4").name)
    println(Employee5("fn", "sn").name)
    println(Employee6("fn", "sn"))
    println(Employee6("fn_sn"))
}