class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate>{
    override fun contains(value: MyDate): Boolean {
        return value in start..endInclusive
    }
}

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in DateRange(first, last)
}
