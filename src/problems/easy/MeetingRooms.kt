package problems.easy


/*
https://leetcode.com/problems/meeting-rooms/

252. Meeting Rooms
Easy

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true


TC -> O(nlogn) due to sorting
SC -> O(1) no extra space required

 */


fun main() {
    val list =
        listOf<IntArray>(intArrayOf(4, 5), intArrayOf(2, 3), intArrayOf(3, 6), intArrayOf(5, 7), intArrayOf(7, 8))

    print(canAttendAllAppointments(list))

}


fun canAttendAllAppointments(intervals: List<IntArray>): Boolean {

    var list = intervals.sortedBy { it.first() }

    var pointer = 0

    while (pointer < list.lastIndex) {
        if (list[pointer].last() > list[pointer + 1].first()) return false else pointer++
    }

    return true
}