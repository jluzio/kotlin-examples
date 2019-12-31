package com.example.kotlin.course.io

import java.io.File

fun main() {
    // walkTopDown: dirs then files
    File(".").walkTopDown()
        .filter { it.extension == "kt" }
        .forEach { println(it) }
}