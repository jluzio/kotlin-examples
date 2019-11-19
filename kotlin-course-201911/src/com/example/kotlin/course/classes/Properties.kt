package com.example.kotlin.course.classes

class PropEmployee(name: String) {
    var name = name
    get() = field
    set(value) { field = value }
}