package problems.medium

import kotlin.math.abs


//https://leetcode.com/problems/3sum-closest/
//Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
//Return the sum of the three integers. You may assume that each input would have exactly one solution.
fun main() {

    print(threeSumClosest(intArrayOf(0, 1, 2), 3))
}

fun threeSumClosest(nums: IntArray, target: Int): Int {

    var smallestDiff = Int.MAX_VALUE
    var sortedArr = nums.sortedArray()

    for (i in 0..sortedArr.size - 2) {
        var left = i + 1
        var right = sortedArr.lastIndex

        while (left < right) {
            val sum = sortedArr[i] + sortedArr[left] + sortedArr[right]

            if (sum == target) return sum

            if (abs(target - sum) < abs(smallestDiff)) smallestDiff = target - sum

            if (sum < target) left++ else right--
        }
    }
    return target - smallestDiff
}
