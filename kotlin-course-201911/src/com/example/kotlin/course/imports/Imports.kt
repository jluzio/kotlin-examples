package com.example.kotlin.course.imports

import com.example.kotlin.course.extensions.extFun
import com.example.kotlin.course.extensions.extFun as xpto
import com.example.module.moduleFun
import com.example.module.moduleFun as aliasFun

fun main() {
    // some-module was created as module and added as module dependency
    moduleFun()
    //alias
    aliasFun()

    "asd".extFun()
    // alias
    "asd".xpto()
}