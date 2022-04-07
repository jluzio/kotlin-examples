package org.example.kotlin.playground

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate

class IdiomsTest {
  data class Customer(val name: String, val email: String)
  data class MutableCustomer(var name: String, var email: String)

  @Test
  fun dtos() {
    var c1 = Customer("name1", "email1")
    println(c1)
    var c2 = MutableCustomer("name2", "email2")
    println(c2)
  }

  @Test
  fun default_values() {
    fun foo(a: Int = 0, b: String = "") {
      // ...
    }

    val list = listOf(-1, 2, -3, 4)
    val positives1 = list.filter { x -> x > 0 }
    val positives2 = list.filter { it > 0 }
  }

  @Test
  fun list_filter() {
    var list = listOf(0, -1, 2, -3, 4)
    val positives1 = list.filter { x -> x > 0 }
    println(positives1)
    val positives2 = list.filter { it > 0 }
    println(positives2)
  }

  @Test
  fun string_interpolation() {
    var name = "John"
    println("Name $name")
  }

  @Test
  fun instance_check() {
    var x: Any = ""
    when (x) {
      is String -> println("is String")
      is LocalDate -> println("is LocalDate")
      else -> println("is Unknown")
    }
  }

  @Test
  fun traversing_map_list_pairs() {
    println("map")
    var map = mapOf(1 to "x", 2 to "y", -1 to "zz")
    for ((k, v) in map) {
      println("$k -> $v")
    }
    var listOfPairs = listOf(1 to "x", 2 to "y", -1 to "zz")
    println("listOfPairs")
    for ((k, v) in listOfPairs) {
      println("$k -> $v")
    }
  }

  @Test
  fun using_ranges() {
    var list1 = ArrayList<Int>()
    var list2 = ArrayList<Int>()
    var list3 = ArrayList<Int>()
    var list4 = ArrayList<Int>()

    for (i in 1..100) {
      list1.add(i)
    }  // closed range: includes 100
    for (i in 1 until 100) {
      list2.add(i)
    } // half-open range: does not include 100
    for (x in 2..10 step 2) {
      list3.add(x)
    }
    for (x in 10 downTo 1) {
      list4.add(x)
    }
    if (5 in 1..10) {
      println("is in 1..10")
    }

    println("list1: $list1")
    println("list2: $list2")
    println("list3: $list3")
    println("list4: $list4")
  }

  @Test
  fun read_only_collections() {
    val list = listOf("a", "b", "c")
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    val mutable_list = ArrayList(listOf("a", "b", "c"))

    // list.add does not exist
    mutable_list.add("d")

    println(list)
    println(map)
    println(mutable_list)
  }

  @Test
  fun map() {
    val map = HashMap(mapOf("a" to 1, "b" to 2, "c" to 3))
    println(map["a"])
    map["a"] = 5
    println(map["a"])
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
  fun extensions() {
    fun String.spaceToCamelCase(): String {
      return "CaMelCaSe"
    }

    println("Convert this to camelcase".spaceToCamelCase())
  }

  object SingletonBean {

    val name = "Name"
  }

  @Test
  fun singleton() {
    println(SingletonBean.name)
  }

  @Test
  fun if_not_null_shorthand() {
    val files = File("Test").listFiles()
    // If not null shorthand
    println(files?.size)
    // If not null and else shorthand
    println(files?.size ?: "empty")
  }

  @Test
  fun if_null_execute() {
    val values = mapOf("name" to "name of x", "not_email" to 6)
    try {
      val name = values["name"] ?: throw IllegalStateException("Name is missing!")
      println(name)
    } catch (e: Exception) {
      fail("not expected")
    }
    try {
      val email = values["email"] ?: throw IllegalStateException("Email is missing!")
      println(email)
      fail("not expected")
    } catch (e: Exception) {
      // expected
    }
  }

  @Test
  fun first_of_possible_empty_collection() {
    var emails: Collection<String>
    emails = listOf()
    println("value: '${emails.firstOrNull() ?: ""}'")
    emails = listOf("not-null!")
    println("value: '${emails.firstOrNull() ?: ""}'")
  }

  @Test
  fun execute_if_not_null() {
    val value = null

    value?.let {
      println("not null value")
    }
    println("value: $value")
  }

  @Test
  fun map_nullable_value_if_not_null() {
    // TODO
    val objNull = null
    val objNotNull = "test"

    println(objNull?.let { v -> "not null: $v" })
    println(objNotNull?.let { v -> "not null: $v" })
  }

  @Test
  fun transform() {
    fun transformFn(color: String): Int {
      return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
      }
    }

    println(transformFn("Green"))
    println(transformFn("Blue"))
  }

  @Test
  fun assignment_exprs() {
    val try_result = try {
      Math.random()
    } catch (e: ArithmeticException) {
      throw IllegalStateException(e)
    }
    println(try_result)

    for (i in 1..3) {
      val if_target = (Math.random() * 5).toInt()
      val if_result = if (if_target == 1) {
        "one"
      } else if (if_target == 2) {
        "two"
      } else {
        "other"
      }
      println(if_result)
    }
  }

  @Test
  fun builder_style_usage_of_methods_that_return_unit() {
    fun arrayOfMinusOnes(size: Int): IntArray {
      return IntArray(size).apply { fill(-1) }
    }
    println(arrayOfMinusOnes(5).asList())
  }

  @Test
  fun single_expression_functions() {
    fun getAnswer() = 42
    println(getAnswer())

    fun transform_ex(color: String): Int = when (color) {
      "Red" -> 0
      "Green" -> 1
      "Blue" -> 2
      else -> throw IllegalArgumentException("Invalid color param value")
    }
    println(transform_ex("Red"))
  }

  @Test
  fun try_resources() {
    val stream = Files.newInputStream(Paths.get("./build.gradle.kts"))
    stream.buffered().reader().use { reader ->
      println(reader.readText())
    }
  }

  @Test
  fun convenient_form_generic_function_requires_generic_type_info() {
    // considering other dependencies
    //  public final class Gson {
    //     ...
    //     public <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
    //     ...

    // this is what we want
    // inline fun <reified T: Any> Gson.fromJson(json: JsonElement): T = this.fromJson(json, T::class.java)
    println("TODO: complete test")
  }

  @Test
  fun consume_nullable_boolean() {
    val b: Boolean? = null
    if (b == true) {
      println("bool is true")
    } else {
      println("bool is false or null")
    }
  }

  @Test
  fun swapping_two_vars() {
    var a = 1
    var b = 2
    a = b.also { b = a }
    println("a: $a | b: $b")
  }
}