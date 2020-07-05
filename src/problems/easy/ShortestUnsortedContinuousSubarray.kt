package problems.easy

import java.lang.Integer.max
import java.lang.Integer.min

/*
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
581. Shortest Unsorted Continuous Subarray
Easy

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.


TC -> O(N)
SC -> O(1 )

 */

fun main() {

    print(findUnsortedSubarray2(intArrayOf(1, 3, 2, 2, 2)))
}

fun findUnsortedSubarray(nums: IntArray): Int {
    val nums = nums
    var low = 0
    var high: Int = nums.lastIndex
    // find the first number out of sorting order from the beginning
    // find the first number out of sorting order from the beginning
    while (low < nums.lastIndex && nums[low] <= nums[low + 1]) low++

    if (low == nums.lastIndex) // if the array is sorted
        return 0

    // find the first number out of sorting order from the end

    // find the first number out of sorting order from the end
    while (high > 0 && nums[high] >= nums[high - 1]) high--

    // find the maximum and minimum of the subarray

    // find the maximum and minimum of the subarray
    var subarrayMax = Int.MIN_VALUE
    var subarrayMin = Int.MAX_VALUE
    for (k in low..high) {
        subarrayMax = max(subarrayMax, nums[k])
        subarrayMin = min(subarrayMin, nums[k])
    }

    // extend the subarray to include any number which is bigger than the minimum of the subarray

    // extend the subarray to include any number which is bigger than the minimum of the subarray
    while (low > 0 && nums[low - 1] > subarrayMin) low--
    // extend the subarray to include any number which is smaller than the maximum of the subarray
    // extend the subarray to include any number which is smaller than the maximum of the subarray
    while (high < nums.lastIndex && nums[high + 1] < subarrayMax) high++

    return high - low + 1
}

fun findUnsortedSubarray2(nums: IntArray): Int {  //<- my implementation
    val nums = nums
    var low = 0
    var high: Int = nums.lastIndex


    while (low < nums.lastIndex && nums[low] <= nums[low + 1]) low++

    if (low == nums.lastIndex) return 0

    while (high > 0 && nums[high] >= nums[high - 1]) high--

    var subArrMax = Int.MIN_VALUE
    var subArrMin = Int.MAX_VALUE

    for (index in low..high) {
        subArrMax = max(subArrMax, nums[index])
        subArrMin = min(subArrMin, nums[index])
    }

    while (low > 0 && nums[low - 1] > subArrMin) low--

    while (high < nums.lastIndex && nums[high + 1] < subArrMax) high++

    return high - low + 1
}