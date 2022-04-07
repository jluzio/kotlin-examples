package org.example.kotlin.playground

import org.junit.jupiter.api.Test
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class DelegatedPropertiesTest {

  @Test
  fun delegate() {
    var bean = Example()
    bean.text = "test"
    println("bean.text: ${bean.text}")
  }

  class Example {

    var text: String by GetSetDelegate()
  }

  class GetSetDelegate : ReadWriteProperty<Any?, String> {

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
      return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
      println("$value has been assigned to '${property.name}' in $thisRef.")
    }
  }

  @Test
  fun lazy_property() {
    val lazyProp: String by lazy {
      // compute the string
      println("Compute")
      "test" + "-" + "val"
    }
    println("Lazy Prop")
    println(lazyProp)
    println(lazyProp)
  }

  @Test
  fun observable() {
    class User {

      var name: String by Delegates.observable("<no name>") { prop, old, new ->
        println("$old -> $new")
      }
    }

    val user = User()
    user.name = "first"
    user.name = "second"
    println("name: ${user.name}")
  }

  @Test
  fun map_delegate() {
    class ImmutableUser(val map: Map<String, Any?>) {

      val name: String by map
      val age: Int by map
    }

    val immutableUser = ImmutableUser(mapOf(
        "name" to "John Doe",
        "age" to 25
    ))
    println(immutableUser.name)
    println(immutableUser.age)

    class MutableUser(val map: MutableMap<String, Any?>) {

      val name: String by map
      val age: Int by map
    }

    val mutableUser = MutableUser(mutableMapOf(
        "name" to "John Doe",
        "age" to 25
    ))
    println(mutableUser.name)
    println(mutableUser.age)
    // mutableUser.name = "test"
  }
}