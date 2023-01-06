package com.example.kotlin.course.interop

class KotlinTarget(@JvmField var field: String = "default") {
  companion object {

    const val constField = 4

    @JvmField
    val field = 23

    @JvmStatic
    fun staticPrint() = println("static!")

    fun optionalParamsFun(str: String, value: Int = 23) = println("$str | $value")

    @JvmOverloads
    fun optionalParamsFunOverloads(str: String, value: Int = 23) = println("$str | $value")
  }
}