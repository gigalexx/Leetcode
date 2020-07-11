package problems.medium
/*
https://leetcode.com/problems/merge-intervals/
56. Merge Intervals
Medium

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


TC --> N(LogN) because of sorting
SC --> O(N) because of sorting as well

 */



fun main() {

}

fun merge(intervals: Array<IntArray>): Array<IntArray> {

    var input = intervals
    input.sortBy { it[0] }

    val mergedIntervals = arrayListOf<IntArray>()

    if (input.isEmpty()) return intervals

    val iterator = input.iterator()

    var interval = iterator.next()
    var start = interval.first()
    var end = interval.last()

    while (iterator.hasNext()) {
        interval = iterator.next()
        if (interval.first() <= end) end = kotlin.math.max(end, interval.last()) else {
            mergedIntervals.add(intArrayOf(start, end))
            start = interval.first()
            end = interval.last()
        }
    }

    mergedIntervals.add(intArrayOf(start, end))

    return mergedIntervals.toTypedArray()
}