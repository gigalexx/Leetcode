package problems.medium

fun main() {

    print(findMinSubArray(intArrayOf(2, 1, 5, 2, 8), 7))
}

fun findMinSubArray(arr: IntArray, sum: Int): Int {
    var min = Int.MAX_VALUE
    var left = 0
    var right = 0
    var currSum = 0

    while (right < arr.size) {
        currSum += arr[right]
        if (currSum >= sum) {
            while (currSum >= sum && left <= right) {
                currSum -= arr[left]
                left++
            }
            min = kotlin.math.min(min, currSum)
        }
        right++
    }

    return if (min == Int.MAX_VALUE) -1 else right + 1 - left
}