package problems.easy

fun main() {
    val array = intArrayOf(1)

    print(maxSubArray2(array))
}


fun maxSubArray(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums[0]
    } else if (nums.isEmpty()) {
        throw Exception("Empty array")
    }
    var max = nums[0]
    var sum = nums[0]
    for (index in 1..nums.lastIndex) {                        // Start from second element. ie index #1
        if (sum < 0) sum = nums[index] else sum += nums[index]
        if (max < sum) max = sum
    }
    return max
}

fun maxSubArray2(nums: IntArray): Int {
    if(nums.isEmpty()) throw Exception("Empty array")
    var max = nums[0]
    var sum = nums[0]
    for (index in 1..nums.lastIndex) {
        sum += nums[index]
        sum = maxOf(sum, nums[index])
        max = maxOf(sum, max)
    }
    return max
}
