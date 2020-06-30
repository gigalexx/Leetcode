package problems.medium
//https://leetcode.com/problems/3sum/
//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//Note:
//The solution set must not contain duplicate triplets.

fun main() {

print(threeSum(intArrayOf(0,0,0)))
}
fun threeSum(nums: IntArray): List<List<Int>> {

    val arr = nums.sortedArray()

    val triplets = arrayListOf<ArrayList<Int>>()

    for (i in 0..arr.size - 2) {
        if (i > 0 && arr[i] == arr[i - 1]) continue
        findPair(arr, -arr[i], i + 1, triplets)


    }
    return triplets
}

fun findPair(arr: IntArray, targetSum: Int, left: Int, triplets: ArrayList<ArrayList<Int>>) {
    var left = left
    var right = arr.lastIndex

    while (left < right) {
        val currSum = arr[left] + arr[right]

        if (currSum == targetSum) {
            triplets.add(arrayListOf(-targetSum, arr[left], arr[right]))

            left++
            right--

            while (left< right && arr[left] == arr[left - 1]) left++
            while (left < right && arr[right] == arr[right + 1]) right--
        } else if (currSum < targetSum) {
            left++
        } else {
            right--
        }
    }
}
