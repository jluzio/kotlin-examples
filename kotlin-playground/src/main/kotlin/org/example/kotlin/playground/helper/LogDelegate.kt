package org.example.kotlin.playground.helper

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.companionObject

class LogDelegate<in R : Any> : ReadOnlyProperty<R, Logger> {
  override fun getValue(thisRef: R, property: KProperty<*>)
      = LoggerFactory.getLogger(getClassForLogging(thisRef.javaClass))
}

inline fun <T : Any> getClassForLogging(javaClass: Class<T>): Class<*> {
  return javaClass.enclosingClass?.takeIf {
    it.kotlin.companionObject?.java == javaClass
  } ?: javaClass
}