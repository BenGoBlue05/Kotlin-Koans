
import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)

operator fun MyDate.plus(timeIntervalCount: TimeIntervalCount): MyDate =
        addTimeIntervals(timeIntervalCount.timeInterval, timeIntervalCount.count)

operator fun TimeInterval.times(num: Int) : TimeIntervalCount = TimeIntervalCount(this, num)

class TimeIntervalCount(val timeInterval: TimeInterval, val count: Int)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
