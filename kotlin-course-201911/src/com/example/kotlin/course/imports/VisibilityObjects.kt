package com.example.kotlin.course.imports

val global_public = 42
private val global_private = 42
internal val global_internal = 42

object VisibilityObjects  {
    val public = 42
    private val private = 42
    internal val internal = 42
}

fun main() {
    println(global_public) // visible everywhere
    println(global_private) // visible in the same file
    println(global_internal) // visible in the same module

    println(VisibilityObjects.public)
    // println(VisibilityObjects.private) // error!
    println(VisibilityObjects.internal)
}