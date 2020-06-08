package problems.medium

fun main() {

    productExceptSelf(intArrayOf(1, 2, 3, 4))

}

fun productExceptSelf(nums: IntArray): IntArray {

    val leftArray = IntArray(nums.size)
    val rightArray = IntArray(nums.size)

    leftArray[0] = 1
    rightArray[nums.lastIndex] = 1

    for (index in 1..nums.lastIndex) {
        leftArray[index] = nums[index - 1] * leftArray[index - 1]
    }

    for (index in nums.lastIndex - 1 downTo 0) {
        rightArray[index] = nums[index + 1] * rightArray[index + 1]
    }

    for (index in nums.indices) {
        nums[index] = leftArray[index] * rightArray[index]
    }

    return nums
}