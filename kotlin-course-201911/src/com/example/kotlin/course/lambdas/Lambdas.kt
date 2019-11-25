package com.example.kotlin.course.lambdas

import java.lang.StringBuilder

fun main() {
    val employees = listOf(
        Employee("John", "Doe", 2000),
        Employee("Jane", "Doe", 2002)
    )

    // if lambda is last param, () can be omitted
    println(employees.minBy({ it.startYear }))

    println(employees.minBy { it.startYear })
    println(employees.minBy { e -> e.startYear })


    local_return_lambda() // "inc 9"
    return_to_lambda() // "inc 9", "!inc 9"

    using_labels()

}

// receiver lambdas
fun countTo100_with(): String {
    return with(StringBuilder()) {
        for (i in 1..99) {
            append(i)
            append(",")
        }
        append("100")
        toString()
    }
}

// receiver lambdas
fun countTo100_apply(): String {
    return StringBuilder().apply {
        for (i in 1..99) {
            append(i)
            append(",")
        }
        append("100")
    }.toString()
}

fun local_return_lambda() {
    val array = Array(10) { it }
    array.forEach {
        if (it === 9) {
            println("inc 9")
            return
        }
    }
    println("!inc 9")
}

fun return_to_lambda() {
    val array = Array(10) { it }
    array.forEach lambda_id@ {
        if (it === 9) {
            println("values has 9")
            return@lambda_id
        }
    }
    println("values hasn't got 9")
}

fun using_labels() {
    "Some string".apply label@ {
        "Another string".apply {
            println(toString())
            println(this@label.toString())
        }
    }
}
