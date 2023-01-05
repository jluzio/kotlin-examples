package com.example.kotlin.playground

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class BasicTypesTest {

  @Test
  fun literal_constants() {
    val dec = 123
    val long = 123L
    val numberUnderscoreReadable = 1_000_000
    println("#dec | $long | $numberUnderscoreReadable")
  }

  @Test
  fun primitives_vs_objects_referential_equality() {
    /*
    * Referential equality: check if it's the same object
    * a === b
    * <->
    * is same object
    */
    val a: Int = 10000
    // note: deprecated
//    assertThat(a === 10000).isTrue // Prints 'true'
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    assertThat(boxedA === anotherBoxedA).isFalse // !!!Prints 'false'!!!
  }

  @Test
  fun primitives_vs_objects_structural_equality() {
    /*
    * Structural equality: check if one object .equals() another
    * a == b
    * <->
    * a?.equals(b) ?: (b === null)
    */
    val a: Int = 10000
    assertThat(a == 10000).isTrue // Prints 'true'
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    assertThat(boxedA == anotherBoxedA).isTrue // Prints 'true'
  }

  @Test
  fun explicit_conversions() {
    val i: Int? = 1
    val l1: Long? = 1
    val l2: Long? = i?.toLong()
    assertThat(l1 == l2).isTrue
  }
}