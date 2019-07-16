import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

enum class TimeInterval { DAY, WEEK, YEAR }
data class TimeIntervalLength(val timeInterval: TimeInterval, val value: Int)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)
operator fun MyDate.plus(timeIntervalLength: TimeIntervalLength): MyDate = addTimeIntervals(timeIntervalLength.timeInterval, timeIntervalLength.value)
operator fun TimeInterval.times(times: Int) = TimeIntervalLength(this, times)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
