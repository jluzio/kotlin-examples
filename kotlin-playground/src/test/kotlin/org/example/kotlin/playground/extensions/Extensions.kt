package org.example.kotlin.playground.extensions

fun List<Int>.removeNegativeValues() = this.filter { v -> v >= 0 }

fun Any?.toStringNull(): String {
    if (this == null) return "null"
    // after the null check, 'this' is autocast to a non-null type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}

val <T> List<T>.prevLastIndex: Int
    get() = Math.max(0, size - 2)
