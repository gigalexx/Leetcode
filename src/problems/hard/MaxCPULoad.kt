package problems.hard

import java.util.*
import kotlin.math.max

/*

 */

fun main() {
    val list = arrayOf(intArrayOf(6, 7, 10), intArrayOf(2, 4, 11), intArrayOf(8, 12, 15))

    print(maxCPULoad(list))
}

fun maxCPULoad(intervals: Array<IntArray>): Int {

    if (intervals.size < 2) return intervals.size
    intervals.sortBy { it.first() }

    var maxLoad = 0
    val comparator = compareBy<IntArray> { it[1] }
    val minHeap = PriorityQueue<IntArray>(intervals.size, comparator)


    for (interval in intervals) {
        while (!minHeap.isEmpty() && interval.first() >= minHeap.peek()[1]) minHeap.poll()

        minHeap.offer(interval)

        var curSum = minHeap.sumBy { it.last() }

        maxLoad = max(maxLoad, curSum)
    }

    return maxLoad
}