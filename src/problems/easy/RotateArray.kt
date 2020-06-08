package problems.easy

/*
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
Problems.rotate 1 steps to the right: [7,1,2,3,4,5,6]
Problems.rotate 2 steps to the right: [6,7,1,2,3,4,5]
Problems.rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */

fun main() {

    var intArrayOf = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    rotate2(intArrayOf, 3)
}

fun rotate(nums: IntArray, k: Int): Unit {                  // additional array

    val ints = IntArray(nums.size)

    for (index in nums.indices) {
        val mod = (index + k) % nums.size
        ints[mod] = nums[index]
    }
    for (index in nums.indices) {
        nums[index] = ints[index]
    }
    print(ints.joinToString(","))
}

fun rotate2(nums: IntArray, k: Int) {                         // Problems.reverse variant
    var k = k
    k %= nums.size
    reverse(nums, 0, nums.size - 1)
    reverse(nums, 0, k - 1)
    reverse(nums, k, nums.size - 1)
    print(nums.joinToString(","))
}

fun reverse(nums: IntArray, start: Int, end: Int) {
    var st = start
    var en = end
    while (st < en) {
        val temp = nums[start]
        nums[st] = nums[en]
        nums[en] = temp
        st++
        en--
    }
}