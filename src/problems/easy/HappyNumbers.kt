package problems.easy
/*
https://leetcode.com/problems/happy-number/
202. Happy Number
Easy

Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example:
Input: 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
*/

fun main() {

}

fun isHappy(n: Int): Boolean {
    var fast = n
    var slow = n

    do {
        slow = findQuadraticSum(slow) // 1 step ahead
        fast =
            findQuadraticSum(findQuadraticSum(fast)) // 2 steps ahead

    } while (slow != fast)

    return slow == 1
}

fun findQuadraticSum(input: Int): Int { // SC-O(1) TC - O(log N)
    var sum = 0
    var num = input
    var digit: Int
    while (num > 0) {
        digit = num % 10
        sum += digit * digit
        num /= 10
    }
    return sum
}

fun isHappy2(n: Int): Boolean {   // using hashSet make SC-O(N). TC - O(log N)
    val set = HashSet<Int>()
    if ((n < 1)) return false
    var sum = n
    while (sum != 1) {
        sum = findQuadraticSum(sum)
        if (set.contains(sum)) return false else set.add(sum)

    }
    return true
}
