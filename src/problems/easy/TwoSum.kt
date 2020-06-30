package problems.easy

fun main() {
    val arr = intArrayOf(3, 2, 4)
    print(twoSum(arr, 6).joinToString(","))

}

fun twoSum(nums: IntArray, target: Int): IntArray {

    if (nums.isEmpty()) {
        throw Exception("Empty array")
    }

    val map = HashMap<Int, Int>() // Might use HashSet in case of true or false // Both is good for not sorted array

    for (index in nums.indices) {
        val n = target - nums[index]
        if (map.contains(n)) return intArrayOf(map[n]!!, index) else map[nums[index]] = index
    }
    return intArrayOf()
}

fun twoSum2(nums: IntArray, target: Int): IntArray {   // works only on sorted arrays

    if (nums.isEmpty()) return intArrayOf()

    var p1 = 0
    var p2 = nums.lastIndex

    while (p1 < p2) {
        when {
            target == nums[p1] + nums[p2] -> return intArrayOf(p1, p2)
            target < nums[p1] + nums[p2] -> p2--
            target > nums[p1] + nums[p2] -> p1++
        }
    }
    return intArrayOf()
}