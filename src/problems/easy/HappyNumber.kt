package problems.easy

fun main() {
    print(isHappy(19))
}

fun isHappy(n: Int): Boolean {
    val set = HashSet<Int>()
    if ((n < 1)) return false
    var sum = n
    while (sum != 1) {
        sum = getSum(sum).toInt()
        if (set.contains(sum)) return false else set.add(sum)

    }
    return true
}

fun getSum(nums: Int): Int {
    var num = nums
    var sum = 0
    while (num > 0) {
        val digit = num % 10
        sum = sum.plus(digit * digit)
        num /= 10
    }
    return sum
}