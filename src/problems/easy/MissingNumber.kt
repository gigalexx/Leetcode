package problems.easy

import problems.medium.swap

fun main() {

    print(missingNumber(intArrayOf(8, 3, 5, 2, 4, 6, 0, 1)))


}

fun missingNumber(nums: IntArray): Int {

    var index = 0
    while (index < nums.size) {
        if (nums[index] < nums.size && nums[index] != index) {
            swap2(nums, index, nums[index])
        } else index++
    }

    for (ind in nums.indices) {

        if (nums[ind] != ind) return ind

    }
    return -1
}

fun swap2(nums: IntArray, index: Int, element: Int) {
    val temp = nums[index] //4
    nums[index] = nums[element]  // 1
    nums[element] = temp         // 4
}


fun missingNumber2(nums: IntArray): Int {
    var i = 0
    while (i < nums.size) {
        if (nums[i] < nums.size && nums[i] != nums[nums[i]])
            swap(nums, i, nums[i])
        else
            i++
    }

    // find the first number missing from its index, that will be our required number
    for (i in 0 until nums.size)
        if (nums[i] != i)
            return i

    return nums.size
}

class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {


        val result = ArrayList<Int>()

        var index = 0

        while (index < nums.size) {

            if (nums[index] < nums.size && nums[index] != index) {
                swap(nums, index)
            } else {
                index++
            }

        }


        for (ind in nums.indices) {
            if (nums[ind] != ind) result.add(ind)
        }

        return result
    }

    fun swap(nums: IntArray, index: Int) {
        val temp = nums[nums[index]]
        nums[nums[index]] = nums[index]
        nums[index] = temp
    }
}