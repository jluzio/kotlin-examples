package com.example.kotlin.course

typealias EmployeeSet = Set<Employee>
typealias EmployeeHashSet = HashSet<Employee>

data class Employee(var name: String)

fun main() {
    val emp1 = Employee("emp1")

    val v1: EmployeeSet = setOf(emp1)
    println(v1)

    val v2 = EmployeeHashSet().apply { add(emp1) }
    println(v2)

}