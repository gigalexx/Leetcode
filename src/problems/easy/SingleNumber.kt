package problems.easy

fun main() {
    // find single number in array where all others has duplicates

    val ints = intArrayOf(1, 2, 3, 4, 5, 2, 5, 3, 2)

    print(singleNumber2(ints))
}

fun singleNumber(nums: IntArray): Int {
    val set = HashMap<Int, Int>()
    for(num in nums) {
        if(set.contains(num)) set.remove(num) else set[num] = num
    }
    return set.iterator().next().key
}

fun singleNumber2(nums: IntArray): Int {
    var res = nums[0]
    for(i in 1 until nums.size) {
        res = res xor nums[i]
    }
    return res
}