package com.example.kotlin.playground

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class RangeAndProgressionTest {

  // Experimental (1.8.0): ..<
  @OptIn(ExperimentalStdlibApi::class)
  @Test
  fun range() {
    println("..")
    assertThat((1..5).toList()).contains(1, 2, 3, 4, 5)
    println("..<")
    assertThat((1..< 5).toList()).contains(1, 2, 3, 4)
    println(".. step")
    assertThat((1..5 step 2).toList()).contains(1, 3, 5)
    println("until")
    assertThat((1 until 5).toList()).contains(1, 2, 3, 4)
    println("downTo")
    assertThat((5 downTo 1).toList()).contains(5, 4, 3, 2, 1)

    println("conditions")
    assertThat(3 in 1..5).isTrue
    assertThat(3 !in 1..5).isFalse
  }

  @Test
  fun rangeTo() {
    val date1 = LocalDate.now().plusDays(-2)
    val date2 = LocalDate.now().plusDays(5)

    println("date in range: ${LocalDate.now() in date1..date2}")
  }

  @Test
  fun int_progression() {
    (1..10 step 2).forEach { println(it) }
  }

  @Test
  fun progression() {
    for (v in LocalDate.of(2010, 10, 30)..LocalDate.of(2010, 11, 7) step 2) {
      println(v)
    }
  }

  data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override operator fun compareTo(other: MyDate): Int = when {
      year != other.year -> year - other.year
      month != other.month -> month - other.month
      else -> dayOfMonth - other.dayOfMonth
    }
  }

  operator fun LocalDate.rangeTo(other: LocalDate) = LocalDateProgression(this, other)

  class LocalDateProgression(
    override val start: LocalDate, override val endInclusive: LocalDate,
    val step: Long = 1
  ) : Iterable<LocalDate>, ClosedRange<LocalDate> {

    override fun iterator(): Iterator<LocalDate> {
      return LocalDateProgressionIterator(start, endInclusive, step)
    }

    infix fun step(days: Long) = LocalDateProgression(start, endInclusive, days)
  }

  internal class LocalDateProgressionIterator(
    start: LocalDate, val endInclusive: LocalDate,
    val step: Long
  ) : Iterator<LocalDate> {

    var current = start
    override fun hasNext() = current <= endInclusive
    override fun next(): LocalDate {
      val next = current
      current = current.plusDays(step)
      return next
    }
  }
}