package problems.medium

import java.util.*

/* https://leetcode.com/problems/subarray-product-less-than-k/
713. Subarray Product Less Than K
Medium

Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.

Time complexity #
1) With creating sub-arrays -->The main for-loop managing the sliding window takes O(N) but creating sub-arrays can take up to O(N^2) in the worst case. Therefore overall, our algorithm will take O(N^3).
2) Without creating sub-arrays --> Time Complexity: O(N), where N is the length of nums. left can only be incremented at most N times.


Space complexity #
1) With creating sub-arrays --> Ignoring the space required for the output list, the algorithm runs in O(N) space which is used for the temp list.
2) Without creating sub-arrays --> Space Complexity: O(1)O(1), the space used by prod, left, and ans.
*/

fun main() {

    findSubArrays(intArrayOf(2, 5, 3, 10), 30)

}

fun findSubArrays(nums: IntArray, target: Int): ArrayList<IntArray> {   // if need return all valid sub-arrays --much slower-- O(N^3)

    val subArrays = arrayListOf<IntArray>()

    var product = 1
    var left = 0

    for (right in nums.indices) {
        product *= nums[right]
        while (product >= target && left < nums.size) product /= nums[left++]

        // since the product of all numbers from left to right is less than the target therefore,
        // all sub-arrays from left to right will have a product less than the target too; to avoid
        // duplicates, we will start with a subarray containing only arr[right] and then extend it

        val tempList = arrayListOf<Int>()

        for (i in right downTo left) {
            tempList.add(0, nums[i])
            subArrays.add(tempList.toIntArray())
        }
    }
    return subArrays
}

fun numSubarrayProductLessThanK(nums: IntArray, target: Int): Int {  // if need return numbers of valid sub-arrays  --much faster-- O(N)
    var product = 1
    var left = 0
    var ans = 0

    for (right in nums.indices) {
        product *= nums[right]
        while (product >= target && left < nums.size) product /= nums[left++]

        if (right >= left) ans += right - left + 1

    }
    return ans
}