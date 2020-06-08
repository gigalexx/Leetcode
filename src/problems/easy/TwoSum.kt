package problems.easy

fun main() {
    val arr = intArrayOf(2, 7, 11, 15)
    print(twoSum(arr, 9).joinToString(","))

}

fun twoSum(nums: IntArray, target: Int): IntArray {

    if (nums.isEmpty()) {
        throw Exception("Empty array")
    }
    val arr = IntArray(2)
    val map = HashMap<Int,Int>() // Might use HashSet in case of true or false // Both is good for not sorted array

    for (index in nums.indices) {
        val n = target - nums[index]
        if (map.contains(n)) {
            arr[0] = map[n]!!
            arr[1] = index
            break
        } else {
            map[nums[index]] = index
        }
    }
    return arr
}