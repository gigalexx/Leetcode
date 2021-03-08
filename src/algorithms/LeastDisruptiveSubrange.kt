package algorithms

import kotlin.math.abs
import kotlin.math.min
import kotlin.random.Random

fun main() {

    for (i in 0..9) {
        if (i % 3 == 1) print(" " + i * i)
    }

    val original = IntArray(10000)
    var index = 0

    repeat(10000) {
        original[index] = Random.nextInt(-100, 100)
        index++
    }

    val replacements = intArrayOf(3, 5, 3)


    println(getLeastDistance(original, replacements))
    println(getLeastDistance2(original, replacements))
}

fun getLeastDistance(original: IntArray, replacement: IntArray): Int {

    var minDistance = Int.MAX_VALUE
    var curDistance: Int

    for (indexOr in 0..original.lastIndex - replacement.lastIndex) {
        curDistance = 0
        for (num in replacement) {
            curDistance += abs(original[indexOr] - num)
        }
        minDistance = min(minDistance, curDistance)
    }

    return minDistance
}

fun getLeastDistance2(original: IntArray, replacement: IntArray): Int {

    var minDistance: Int

    var replacementSum = 0
    var curOriginalSum = 0

    for (index in replacement.indices) {
        replacementSum += replacement[index]
        curOriginalSum += original[index]
    }

    minDistance = abs(curOriginalSum - replacementSum)
    var curDistance = minDistance
    var indx = 0
    for (index in replacement.lastIndex + 1..original.lastIndex - replacement.lastIndex) {
        curDistance = abs(curDistance - original[indx++] + original[index])
        minDistance = min(minDistance, curDistance)

    }

    return minDistance
}
