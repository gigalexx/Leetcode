package problems.medium

import java.util.*
import kotlin.math.max

/*
https://leetcode.com/problems/meeting-rooms-ii/

253. Meeting Rooms II
Medium

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1

TC --> O(NlogN) due to sorting
SC --> O(N)

 */

fun main() {
    val list = arrayOf(intArrayOf(0, 30), intArrayOf(5, 10), intArrayOf(15, 20))

    print(minMeetingRooms(list))
}

fun minMeetingRooms(intervals: Array<IntArray>): Int {

    if (intervals.size < 2) return intervals.size
    intervals.sortBy { it.first() }

    var minRooms = 0
    val comparator = compareBy<IntArray> { it.last() }
    val minHeap = PriorityQueue<IntArray>(intervals.size, comparator)


    for (interval in intervals) {
        while (!minHeap.isEmpty() && interval.first() >= minHeap.peek().last()) minHeap.poll()

        minHeap.offer(interval)

        minRooms = max(minRooms, minHeap.size)
    }

    return minRooms
}