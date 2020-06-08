package problems.easy

import java.util.*


fun main(){
    print(thirdMax(intArrayOf(3,2,1,5,6,4), 2))
}
fun thirdMax(nums: IntArray, k: Int): Int {
    val maximums = mutableSetOf<Int>()
    for (num in nums) {
        maximums.add(num)
        if (maximums.size > k) {
            maximums.remove(Collections.min(maximums))
        }
    }
    return if (maximums.size == k) {
        Collections.min(maximums)
    } else Collections.max(maximums)
}