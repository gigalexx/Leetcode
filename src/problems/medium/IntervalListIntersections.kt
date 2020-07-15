package problems.medium

import java.lang.Integer.max
import kotlin.math.min

/*
https://leetcode.com/problems/interval-list-intersections/

986. Interval List Intersections
Medium

Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

Example 1:

Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]


Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9


TC --> O(N)
SC --> O(N)


 */

fun main() {

}

fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {

    val intersectionIntervals = mutableListOf<IntArray>()

    var pA = 0
    var pB = 0

    while (pA < A.size && pB < B.size) {

        val low = max(A[pA].first(), B[pB].first())
        val high = min(A[pA].last(), B[pB].last())

        if (low <= high) intersectionIntervals.add(intArrayOf(low, high))

        if (high == A[pA].last()) pB++ else pA++


//        if (A[pA].first() >= B[pB].first() && A[pA].first() <= B[pB].last() || B[pB].first() >= A[pA].first() && B[pB].first() <= A[pA].last()) {
//
//            intersectionIntervals.add(intArrayOf(max(A[pA].first(), B[pB].first()), min(A[pA].last(), B[pB].last())))
//
//        }
//        if (A[pA].last() > B[pB].last()) pB++ else pA++

    }

    return intersectionIntervals.toTypedArray()
}