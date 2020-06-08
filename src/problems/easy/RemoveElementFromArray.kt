package problems.easy

fun main(){
    val nums2 = intArrayOf(3, 2, 2, 3)
    val n = 3
    removeElement(nums2, n)

}


fun removeElement(nums: IntArray, value: Int): Int {
    if (nums.isEmpty()) return 0

    var pF = -1

    for (index in nums.indices) {
        if (nums[index] != value) {
            nums[++pF] = nums[index]
        }
    }
    return pF + 1
}

fun removeElement2(nums: IntArray, value: Int): Int {
    if (nums.isEmpty()) return 0

    var p1 = 0
    var p2 = nums.size
    while (p1 < p2) {
        if (nums[p1] == value) {
            nums[p1] = nums[--p2]
        } else {
            p1++
        }
    }
    return p2
}