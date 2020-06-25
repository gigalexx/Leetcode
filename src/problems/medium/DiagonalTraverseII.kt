package problems.medium

fun main() {

    val nums: List<List<Int>> = listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))
    findDiagonalOrder(nums)

}

fun findDiagonalOrder(nums: List<List<Int>>): IntArray {

    val array = IntArray(nums.size * (nums[0].lastIndex + 1))

    var p1 = 0

    for (indexRow in nums.indices) {
        var p2 = indexRow
        for (indexCol in nums[indexRow].indices) {
            while (p2 > -1) {
                array[p1++] = nums[p2][indexCol]
                p2--
            }
        }
    }
    return array
}