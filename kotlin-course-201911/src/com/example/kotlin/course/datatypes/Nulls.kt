package com.example.kotlin.course.datatypes

class Address(val city: String)
class Employee(val name: String, val address: Address)

fun main() {
    val emp: Employee? = null
    println("""emp: ${emp?.address?.city ?: "no city"}""")
    
    val notEmp: Any = "test"
    val emp2 = notEmp as? Employee
    println("emp2: $emp2")
    try {
        val emp2_2 = notEmp as Employee
        println("emp2_2: $emp2_2")
    } catch (e: Exception) {
        println("emp2_2 can't be cast to Employee")
    }

    try {
        val nullVal: String? = null
        // exception is created on cast
        val wronglySureNonNull = nullVal!!
        // this wont be executed
        val resultNull = wronglySureNonNull.toString()
    } catch (e: Exception) {
        println("""Error line must be on "= nullVal!!"""")
        e.printStackTrace()
    }

    val arrayOfIntNulls = arrayOfNulls<Int?>(5)
    arrayOfIntNulls.forEach(::println)
}