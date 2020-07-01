package problems.medium

//https://leetcode.com/problems/3sum-smaller/
//259. 3Sum Smaller
//Medium
//Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

fun main() {


    print(threeSumSmaller(intArrayOf(-1,1,-1,-1),-1))
}

fun threeSumSmaller(nums: IntArray, target: Int): Int {

    var arr = nums.sortedArray()
    var counter = 0

    if(arr.size < 3) return counter

    for (first in 0..arr.size - 2) {

      counter = findPairs(arr, first, target, counter)

    }
    return counter

}

fun findPairs(nums: IntArray, currIndex: Int, target: Int, counter: Int): Int {

    var counter = counter
    var left = currIndex + 1
    var right = nums.lastIndex

    while (left < right) {

        val sum = nums[currIndex] + nums[left] + nums[right]

        if (sum < target){
            counter += right - left
            left++
        } else {
            right--

        }

    }
    return counter
}
