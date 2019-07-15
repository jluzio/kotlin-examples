package org.example.kotlin.playground

import org.junit.Test
import java.time.LocalDate

class RangeAndProgressionTest {

    @Test
    fun range() {
        println("..")
        for (i in 1..5) println(i)
        println(".. step")
        for (i in 1..5 step 2) println(i)
        println("until")
        for (i in 1 until 5) println(i)
        println("downTo")
        for (i in 5 downTo 1) println(i)

        println("conditions")
        println(3 in 1..5)
        println(3 !in 1..5)
    }

    @Test
    fun rangeTo() {
        val date1 = LocalDate.now().plusDays(-2)
        val date2 = LocalDate.now().plusDays(5)

        println("date in range: ${LocalDate.now() in date1..date2}")
    }

    @Test
    fun int_progression() {
        (1..10 step 2).forEach{ println(it) }
    }

    @Test
    fun progression() {
        for (v in LocalDate.of(2010, 10, 30)..LocalDate.of(2010, 11, 7) step 2) {
            println(v)
        }
    }

    data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
        override operator fun compareTo(other: MyDate): Int = when {
            year != other.year -> year - other.year
            month != other.month -> month - other.month
            else -> dayOfMonth - other.dayOfMonth
        }
    }

    operator fun LocalDate.rangeTo(other: LocalDate) = LocalDateProgression(this, other)

    class LocalDateProgression(override val start: LocalDate, override val endInclusive: LocalDate, val step: Long = 1): Iterable<LocalDate>, ClosedRange<LocalDate> {
        override fun iterator(): Iterator<LocalDate> {
            return LocalDateProgressionIterator(start, endInclusive, step)
        }
        infix fun step(days: Long) = LocalDateProgression(start, endInclusive, days)
    }

    internal class LocalDateProgressionIterator(start: LocalDate, val endInclusive: LocalDate, val step: Long) : Iterator<LocalDate> {
        var current = start
        override fun hasNext() = current <= endInclusive
        override fun next(): LocalDate {
            val next = current
            current = current.plusDays(step)
            return next
        }
    }
}