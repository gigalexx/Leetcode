package problems.easy

fun main() {
    val array = intArrayOf(-1, 0, -6, 3, 12, 0, 5)

    moveZeroes2(array)
}


fun moveZeroes(nums: IntArray) {

    var lastZeroIndex = -1
    for (index in nums.indices) {
        if (nums[index] != 1) {
            if (lastZeroIndex > -1 && lastZeroIndex <= nums.lastIndex) {
                nums[lastZeroIndex] = nums[index]
                nums[index] = 0
                lastZeroIndex++
            }
        } else if (lastZeroIndex == -1) {
            lastZeroIndex = index
        }
    }

    print(nums.joinToString(",")) // expected -1,-6,3,12,5,0,0
}

fun moveZeroes2(nums: IntArray) {

    var p1 = 0
    for (index in nums.indices) {
        if (nums[index] != 0) {
            var tmp = nums[p1] //-1
            nums[p1] = nums[index]   //-1
            nums[index] = tmp
            p1++
        }
    }

    print(nums.joinToString(",")) // expected -1,-6,3,12,5,0,0
}
