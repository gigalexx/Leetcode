package problems.easy

import java.util.concurrent.TimeUnit
import kotlin.math.max
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.TimeMark
import kotlin.time.TimeSource

fun main() {
    val arrayOf = intArrayOf(0, 1, 2, 2)

    fruitIntoBaskets(arrayOf)
//    findNonDuplicate(arrayOf)
//    minSteps(6)
}

fun containsDuplicate(nums: IntArray): Boolean {

    val hashSet = HashSet<Int>()
    for (num in nums) {
        if (!hashSet.add(num)) return true
    }
    return false
}

fun findNonDuplicate(nums: IntArray): Int? {

    val set = mutableSetOf<Int>()

    for (num in nums) {
        if (set.contains(num)) set.remove(num) else set.add(num)
    }


    return set.firstOrNull()
}

fun minSteps(i: Int): Int {

    val bills = intArrayOf(1, 5, 10, 50, 100)
    var inputSum = i
    var paperCounter = 0


    for (billIndex in bills.lastIndex downTo 0) {
        val result = inputSum / bills[billIndex]
        if (result > 0) {
            paperCounter += result
            inputSum -= result * bills[billIndex]
        } else continue
        if (inputSum == 0) break
    }

//    while (inputSum != 0) {
//
//        when {
//
//            inputSum / 100 > 0 -> {
//                val currCount = inputSum / 100
//                paperCounter += currCount
//                inputSum -= currCount * 100
//            }
//            inputSum / 50 > 0 -> {
//                val currCount = inputSum / 50
//                paperCounter += currCount
//                inputSum -= currCount * 50
//            }
//            inputSum / 10 > 0 -> {
//                val currCount = inputSum / 10
//                paperCounter += currCount
//                inputSum -= currCount * 10
//            }
//
//            else -> {
//                paperCounter += inputSum
//                inputSum = 0
//            }
//
//        }
//
//
//    }

    return paperCounter
}


fun fruitIntoBaskets(tries: IntArray): Int {

    var max = 0
    var currMax = 0
    val typeSet = mutableSetOf<Int>()
    var nextTypeIndex = 0
    var nextPointer = 0

    while (nextPointer <= tries.lastIndex) {

        if (typeSet.size == 1 && !typeSet.contains(tries[nextPointer])) nextTypeIndex = nextPointer

        typeSet.add(tries[nextPointer])

        if (typeSet.size < 3) {
            currMax++
            nextPointer++
        } else {
            max = kotlin.math.max(max, currMax)
            if (nextTypeIndex != 0) nextPointer = nextTypeIndex
            currMax = 0
            typeSet.clear()
        }

    }

    return kotlin.math.max(max, currMax)
}


fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {

    var biggestElement = 0

    for (num in nums){
        biggestElement = max(biggestElement,num)
    }

    mutableMapOf<Int,Int>()
    for (num in nums){
       
    }



return true
}