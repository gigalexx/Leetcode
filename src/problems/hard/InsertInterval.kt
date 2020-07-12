package problems.hard

import kotlin.math.max
import kotlin.math.min

/*
https://leetcode.com/problems/insert-interval/

57. Insert Interval
Hard

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

TC --> O(N)
SC --> O(N)
 */

fun main() {

    insert(arrayOf(intArrayOf(1, 5), intArrayOf(6, 9)), intArrayOf(2, 5))
}

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

    val mergedIntervals = arrayListOf<IntArray>()
    var newIntervalRange = newInterval.first()..newInterval.last()

    var index = 0


    while (index < intervals.size && intervals[index].last() < newIntervalRange.first()) {  // add all intervals which less than new one
        mergedIntervals.add(intervals[index])
        index++
    }

    while (index < intervals.size && intervals[index].first() <= newIntervalRange.last) {
        newIntervalRange = min(newInterval.first(), intervals[index].first())..max(
            newIntervalRange.last,
            intervals[index].last()
        ) // merge all overlapped intervals in one
        index++
    }

    mergedIntervals.add(intArrayOf(newIntervalRange.first, newIntervalRange.last)) //add merged intervals

    while (index < intervals.size) mergedIntervals.add(intervals[index++])       // add rest of intervals


    return mergedIntervals.toTypedArray()
}