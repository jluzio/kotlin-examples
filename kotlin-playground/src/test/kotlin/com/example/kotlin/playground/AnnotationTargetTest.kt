package com.example.kotlin.playground

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AnnotationTargetTest {

  @Retention(AnnotationRetention.RUNTIME)
  @Target(AnnotationTarget.PROPERTY_GETTER)
  annotation class MethodAnnotation()

  // https://kotlinlang.org/docs/reference/annotations.html#annotation-use-site-targets
  // annotation is applied to get method
  data class Bean(@get:MethodAnnotation val value: String)

  @Test
  fun test() {
    val bean = Bean("someval")
    val annotations = bean::value.getter.annotations
    println(annotations)
    assertThat(annotations[0] is MethodAnnotation)
      .isTrue()
  }

}