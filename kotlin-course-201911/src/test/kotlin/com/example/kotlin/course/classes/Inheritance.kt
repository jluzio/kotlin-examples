package com.example.kotlin.course.classes

fun main() {
  val printer = LaserPrinter("HP 123")
  printer.printModel()
  printer.printData()
}

abstract class Printer(val modelName: String) {

  open fun printModel() = println("Model = $modelName")
  abstract fun printData()
}

class LaserPrinter(modelName: String) : Printer(modelName) {

  override fun printModel() = println("Model = $modelName")
  override fun printData() = println("Data: [modelName = $modelName]")
}