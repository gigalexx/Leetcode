package problems.easy

import java.util.*
import kotlin.collections.HashMap

fun main() {

    val ch: Char = 0.toChar()
    println("Here is 0 in char : $ch")

    print(jumpingOnClouds(arrayOf(0, 0, 0, 1, 0, 0)))

    //  print(heightChecker(intArrayOf(5, 1, 1, 2, 3, 4, 3, 3)))
}

fun heightChecker(heights: IntArray): Int {

    val heightToFreq = IntArray(101)

    for (height in heights) {
        heightToFreq[height]++
    }

    var result = 0
    var curHeight = 0

    for (element in heights) {
        while (heightToFreq[curHeight] == 0) {
            curHeight++
        }
        if (curHeight != element) {
            result++
        }
        heightToFreq[curHeight]--
    }
    return result
}

fun sockMerchant(n: Int, ar: Array<Int>): Int {

    val map = HashMap<Int, Int>()

    for (num in ar) {
        if (map.contains(num)) map[num] = map[num]!! + 1 else map[num] = 1
    }

    var pairs = 0

    for (num in map.keys) {
        if (map[num]!! < 2) continue else pairs += map[num]!! / 2
    }

    return pairs
}

fun countingValleys(n: Int, s: String): Int {

    val stack = Stack<Int>()
    var level = 0
    var valleysCounter = 0

    for (str in s) {
        if (str == 'D') stack.push(--level) else stack.push(++level)
    }

    while (stack.isNotEmpty()) {
        val curLevel = stack.pop()

        if (curLevel == -1) {
            valleysCounter++
            while (stack.pop() != 0) {
            }

        }

    }


    return valleysCounter

}

fun jumpingOnClouds(c: Array<Int>): Int {

    var jumpCounter = 0

    var p1 = 1

    while (p1 < c.size) {
        if (c[p1] == 1) {
            p1--
        }
        jumpCounter++
        if (p1 + 2 < c.size) p1 += 2 else p1++
    }

    return jumpCounter
}