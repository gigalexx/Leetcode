package problems.easy

fun main(){
    val nums2 = intArrayOf(2, 2, 3, 3)
    val n = 3
    removeDuplication(nums2)

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