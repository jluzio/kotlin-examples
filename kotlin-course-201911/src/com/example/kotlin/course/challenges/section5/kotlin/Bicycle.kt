package com.example.kotlin.course.challenges.section5.kotlin

open class Bicycle (var cadence: Int, var speed: Int, var gear: Int) {
    fun speedUp(value: Int) {
        speed += value
    }
    fun applyBrake(value: Int) {
        speed -= value
    }
}