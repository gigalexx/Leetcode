package Patterns.SlidingWindows

fun main() {


    findMaxSumSubArray(intArrayOf(2, 3, 4, 1, 5), 2)

}

fun findMaxSumSubArray(arr: IntArray, K: Int): Int {
    var maxSum = 0
    var left = 0
    var right = 0
    var currMax = 0

    while (right < arr.size) {
        currMax += arr[right]

        if (right - left >= K - 1) {
            if (maxSum < currMax) {
                maxSum = currMax
            }
            currMax -= arr[left]
            left++
        }
        right++
    }
    return maxSum
}