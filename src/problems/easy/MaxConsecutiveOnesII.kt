package problems.easy

fun main() {

    print(
        findMaxConsecutiveOnes(
            intArrayOf(1,0,111,0,1)
        )
    )
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {

    var left = 0
    var right = 0
    var max = 0
    for (element in nums) {
        right++
        if (element == 0) {
            left = right
            right = 0
        }
        max = kotlin.math.max(max, left + right)
    }
    return max

}