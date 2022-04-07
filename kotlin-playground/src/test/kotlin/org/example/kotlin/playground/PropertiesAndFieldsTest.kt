package org.example.kotlin.playground

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import javax.inject.Inject

const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

class PropertiesAndFieldsTest {

  @Test
  fun property_accessors() {
    class GetSetClass {

      var numberVar: Int? = null

      var numberAsStringVar: String
        get() = numberVar.toString()
        set(value) {
          numberVar = value.toIntOrNull()
        }
    }

    val bean = GetSetClass()
    bean.numberVar = 5
    println("val: ${bean.numberVar} | ${bean.numberAsStringVar}")
    bean.numberAsStringVar = "32"
    println("val: ${bean.numberVar} | ${bean.numberAsStringVar}")
  }

  @Test
  fun property_accessors_field() {
    class GetSetClass {

      // field = same as a tmp var
      var numberVar: Int? = 0
        get() {
          println("calling get")
          return field
        }
        set(value) {
          println("calling set")
          field = value
        }
    }

    val bean = GetSetClass()
    bean.numberVar = 5
    println("val: ${bean.numberVar}")
  }

  @Test
  fun get_set_refining() {
    class TestClass {

      var setterVisibility: String = "abc"
        private set // the setter is private and has the default implementation

      var setterWithAnnotation: Any? = null
        //@Autowired
        @Inject set // annotate the setter with Inject

      fun test() {
        setterVisibility = "cba"
      }
    }

    val obj = TestClass()
    // obj.setterVisibility = "test"
  }

  @Test
  fun compile_time_constants() {
    @Deprecated(SUBSYSTEM_DEPRECATED)
    fun foo() {
      println("deprecated foo")
    }
    foo()
  }

  @Test
  fun late_initialized_properties_and_variables() {
    class LateInitClass {

      lateinit var subject: Any

      fun setup() {
        subject = Any()
      }

      fun isSubjectInited() = println("isInit: ${this::subject.isInitialized}")

      @Test
      fun test() {
        println("test: $subject")  // dereference directly
      }
    }

    val obj = LateInitClass()
    try {
      obj.isSubjectInited()
      println("subject: ${obj.subject}")
      obj.test()
      fail("expected exception")
    } catch (e: UninitializedPropertyAccessException) {
      // expected
    }
    try {
      obj.setup()
      obj.isSubjectInited()
      println("subject: ${obj.subject}")
      obj.test()
    } catch (e: UninitializedPropertyAccessException) {
      fail("unexpected exception")
    }
  }

}