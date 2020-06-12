package Algorithms.Sorting

fun main() {
    print(quickSort(intArrayOf(6, 3, 8, 1, 0, 4, 23, 6, 8, 54, 73, 6)).joinToString(" - "))
}

fun quickSort(nums: IntArray): IntArray {

    if (nums.size <= 1) return nums


    var item = nums.lastIndex


    for (index in item - 1 downTo 0) {
        if (nums[item] < nums[index]) {
            val temp = nums[index]
            if (item - index > 1) {
                nums[index] = nums[item - 1]
                nums[item - 1] = nums[item]
                nums[item] = temp
            } else {
                nums[index] = nums[item]
                nums[item] = temp
            }
            item--
        }
    }


    var leftArr = nums.copyOfRange(0, item)
    var rightArr = nums.copyOfRange(item, nums.size)


    return mergeIt(quickSort(leftArr), quickSort(rightArr))
}

fun mergeIt(leftSide: IntArray, rightSide: IntArray): IntArray {

    var arr: IntArray? = intArrayOf(0)

    if (leftSide == null || leftSide.isEmpty()) return rightSide
    if (rightSide == null || rightSide.isEmpty()) return leftSide

    arr = if (leftSide.last() <= rightSide.first()) {
        leftSide + rightSide
    } else {
        rightSide + leftSide
    }
    return arr
}