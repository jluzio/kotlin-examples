package com.example.kotlin.course.imports

//import com.example.module.moduleFun


fun main() {
  println(global_public)
  // println(global_private) // error! different file
  println(global_internal)

  println(VisibilityObjects.public)
  //println(VisibilityObjects.private) // error! different file
  println(VisibilityObjects.internal)

//  moduleFun()
  // internalModuleFun() // error! different module
  // privateModuleFun() // error! different file
}