package problems.easy

fun main() {

    print(rob(intArrayOf(1, 2, 3, 1)))
}

fun rob(nums: IntArray): Int {
    var prevMax = 0
    var currMax = 0
    for (num in nums) {
        val temp = currMax
        currMax = kotlin.math.max(prevMax + num, currMax)
        prevMax = temp
    }
    return currMax
}