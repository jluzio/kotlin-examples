package com.example.kotlin.playground

import org.junit.jupiter.api.Test

class ObjectExpressionsTest {

  open class Foo(val fooVal: String) {

    fun foo() {
      println("foo: $fooVal")
    }
  }

  @Test
  fun anonymous_class() {
    fun receivesComparator(c: Comparator<Any>) {
      println("received comparator $c")
    }

    receivesComparator(object : Comparator<Any> {
      override fun compare(o1: Any?, o2: Any?): Int {
        return 0
      }
    })
  }

  @Test
  fun anonymous_class_multiple_supertypes() {
    fun receivesComparator(c: Comparator<Any>) {
      println("received comparator $c")
    }

    fun receivesFoo(c: Foo) {
      println("received foo $c")
    }

    var fooAndComparator = object : Foo("42"), Comparator<Any> {
      override fun compare(o1: Any?, o2: Any?): Int {
        return 0
      }
    }

    receivesComparator(fooAndComparator)
    receivesFoo(fooAndComparator)
  }

  @Test
  fun anonymous_simple_object() {
    var obj = object {
      val foo = "Bar"
      val n = 42
    }

    println("${obj.foo} | ${obj.n}")
  }

  @Test
  fun anonymous_class_access() {
    var non_final_value = 1
    val obj = object {
      fun inc() {
        println(++non_final_value)
      }
    }

    for (i in 1..5) {
      obj.inc()
    }
  }

  interface FactoryInterface<T> {

    fun create(): T
  }

  data class ClassWithDefaultCompanion(val value: Int) {
    companion object {

      var counter = 0
      fun create() = ClassWithDefaultCompanion(++counter)
    }
  }

  data class ClassWithCompanion(val value: Int) {
    companion object Factory : FactoryInterface<ClassWithCompanion> {

      var counter = 0
      override fun create() = ClassWithCompanion(++counter)
    }
  }

  @Test
  fun companion_objects() {
    val obj1 = ClassWithDefaultCompanion.create()
    val obj2 = ClassWithCompanion.create()
    val obj3 = ClassWithCompanion.create()
    println("objs: $obj1 | $obj2 | $obj3")
  }

}