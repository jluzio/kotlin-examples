package org.example.kotlin.playground

import org.jetbrains.annotations.NotNull
import org.junit.Assert
import org.junit.Test
import java.lang.annotation.Documented
import java.lang.annotation.RetentionPolicy

class AnnotationTargetTest {

    @Documented
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
        Assert.assertTrue(annotations[0] is MethodAnnotation)
    }

}