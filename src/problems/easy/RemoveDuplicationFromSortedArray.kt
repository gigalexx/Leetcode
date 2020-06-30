package problems.easy

fun main() {
    val nums2 = intArrayOf(2, 2, 3, 3)
    val n = 3
    //  print(removeDuplication2(nums2).joinToString(","))
    print(removeKeyInUnsortedArray(intArrayOf(3, 2, 3, 6, 3, 10, 9, 3), 3).joinToString(","))

}


fun removeDuplication(nums: IntArray): IntArray {
    if (nums.isEmpty()) return nums

    var pF = 0
    for (index in 1..nums.lastIndex) {
        if (nums[index] != nums[pF]) {
            nums[++pF] = nums[index]
        }
    }
    //return pF + 1
    return nums.sliceArray(0..pF)
}

fun removeDuplication2(nums: IntArray): IntArray {
    if (nums.isEmpty()) return nums
    var p1 = 1
    var p2 = 0

    while (p1 < nums.size) {
        if (nums[p1] != nums[p2]) {
            nums[++p2] = nums[p1]
        }
        p1++
    }

    return nums.sliceArray(0..p2)
}

fun removeKeyInUnsortedArray(nums: IntArray, key: Int): IntArray {
    if (nums.isEmpty()) return nums

    var p1 = 0
    var p2 = 0

    while (p1 < nums.size) {
        if (nums[p1] != key) {
            nums[p2++] = nums[p1]
        }
        p1++
    }

    return nums.sliceArray(0 until p2)
}