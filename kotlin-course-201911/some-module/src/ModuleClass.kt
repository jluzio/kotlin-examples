package com.example.module

fun moduleFun() = println("call to some-module:moduleFun")
internal fun internalModuleFun() = println("call to some-module:internalModuleFun")
private fun privateModuleFun() = println("call to some-module:privateModuleFun")

fun main() {
    moduleFun()
    internalModuleFun()
    privateModuleFun()
}