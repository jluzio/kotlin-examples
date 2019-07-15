import java.time.LocalDate

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {

        var compare = year - other.year
        if (compare == 0) {
            compare = month - other.month
        }
        if (compare == 0) {
            compare = dayOfMonth - other.dayOfMonth
        }
        return compare
    }
}

fun compare(date1: MyDate, date2: MyDate) = date1 < date2
