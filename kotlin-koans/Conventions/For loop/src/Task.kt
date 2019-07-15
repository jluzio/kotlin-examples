class DateRange(override val start: MyDate, override val endInclusive: MyDate): Iterable<MyDate>, ClosedRange<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return MyDateIterator(start, endInclusive)
    }
}

internal class MyDateIterator(start: MyDate, val endInclusive: MyDate) : Iterator<MyDate> {
    var current = start
    override fun hasNext() = current <= endInclusive
    override fun next(): MyDate {
        val next = current
        current = current.nextDay()
        return next
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}
