package problems.medium

import myDataStructures.*
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min


fun main() {

    productExceptSelf(intArrayOf(1,2,3,4))

//    val tree = MyBinarySearchTree(12);
//
//    tree.insert(10)
//    tree.insert(15)
//    tree.insert(16)
//    tree.insert(2)
//    tree.insert(8)
//    tree.insert(4)
//    tree.insert(99)
//
//    print(tree.lookup(8))


   //val stack =  QueueBasedOnLinkedList()
    //val stack =  StackBasedOnLinkedList()
   //val stack =  StackBasedOnArrays()
  // val stack =  QueueBasedOnArrays()

//
//    stack.push(1)
//    stack.push(2)
//    stack.push(3)
//    stack.push(4)
//    stack.push(5)
//    stack.push(6)
//
//    println(stack.peek())
//    println(stack.pop())
//    println(stack.peek())
//    println(stack.pop())
//    println(stack.peek())
//    println(stack.pop())
//    println(stack.peek())
//    println(stack.pop())
//    println(stack.peek())
//    println(stack.pop())
//    println(stack.peek())
//    println(stack.pop())
//    println(stack.peek())
//    println(stack.pop())

//    maxArea(intArrayOf(1,8,6,2,5,4,8,3,7))
//    myAtoi("+-2")
//    lengthOfLongestSubstring2("pwwkew")
//    var obj = MyLinkedList2()
//    obj.addAtHead(1)
//    obj.addAtTail(3)
//    obj.addAtIndex(1, 2)
//    obj.get(1)
//    obj.deleteAtIndex(1)
//    obj.get(1)

    val word = "cars"
    val dict = listOf<String>("car", "rs", "ca")
    //  println(wordBreak(word, dict))

    // print(sortedSquares(intArrayOf(-1, 3, 9, 11, 24)))


    val nums1 = intArrayOf(0)
    val m = 0
    val nums2 = intArrayOf(3, 2, 2, 3)
    val n = 3

//    removeElement(nums2, n)

}

fun reverse(x: Int): Int {
    var xString = x.toString()
    xString = if (x < 0) {
        "-" + xString.reversed().substring(0, xString.length - 2)
    } else {
        xString.reversed().substring(0, xString.length - 1)
    }
    return try {
        xString.toInt()
    } catch (e: NumberFormatException) {
        0
    }
}

fun replaceElements(arr: IntArray): IntArray {

    var maxItem = -1
    for (index in arr.lastIndex downTo 0) {
        if (arr[index] > maxItem) {
            val tmp = maxItem
            maxItem = arr[index]
            arr[index] = tmp
        } else {
            arr[index] = maxItem
        }
    }
    arr[arr.lastIndex] = -1
    return arr
}

fun sortedSquares(A: IntArray): IntArray {
    val array = IntArray(A.size)
    var indexEnd = A.lastIndex
    var indexStart = 0
    var arrayIndex = indexEnd

    while (indexEnd >= indexStart) {
        val stResult = A[indexStart] * A[indexStart]
        val endResult = A[indexEnd] * A[indexEnd]
        if (stResult >= endResult) {
            array[arrayIndex] = stResult
            indexStart++
        } else {
            array[arrayIndex] = endResult
            indexEnd--
        }
        arrayIndex--
    }
    return array
}


fun findNumbers(nums: IntArray): Int {
    var maxEven = 0
    nums.forEach {
        if (getSize(it) % 2 == 0) maxEven++
    }
    return maxEven
}

fun getSize(value: Int): Int {
    var counter = 1
    var item = value
    while (item / 10 > 0) {
        counter++
        item /= 10
    }
    return counter
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var maxNumber = 0
    var rowOnes = 0
    nums.forEach {
        if (it == 1) rowOnes++ else {
            maxNumber = max(maxNumber, rowOnes)
            rowOnes = 0
        }
    }
    return max(maxNumber, rowOnes)
}

fun wordBreak(word: String, wordDict: List<String>): Boolean {
    val dp = Array(word.length + 1) { false }
    dp[0] = true

    for (index in 1..word.length) {
        for (j in 0 until index) {
            if (dp[j] && wordDict.contains(word.substring(j, index))) {
                dp[index] = true
                break
            }
        }
    }

    return dp[word.length]

}

fun twoSum(nums: IntArray, target: Int): IntArray {

    val map = HashMap<Int, Int>()

    for (index in nums.indices) {

        val value = target - nums[index]

        if (map.contains(value)) return intArrayOf(map[value]!!, index)

        map.put(nums[index], index)
    }

    return intArrayOf()
}

fun lengthOfLongestSubstring(s: String): Int {

    val set: MutableSet<Char> = HashSet()
    var ans = 0
    var leftSide = 0
    var rightSide = 0
    while (leftSide < s.length && rightSide < s.length) {
        // try to extend the range [i, j]
        if (!set.contains(s[rightSide])) {
            set.add(s[rightSide++])
            ans = max(ans, rightSide - leftSide)
        } else {
            set.remove(s[leftSide++])
        }
    }
    return ans
}

fun lengthOfLongestSubstring2(s: String): Int {
    var leftSide = 0
    var rightSide = 0
    var max = 0

    val set = mutableSetOf<Char>()

    while (rightSide < s.length && leftSide < s.length) {
        if (!set.contains(s[rightSide])) {
            set.add(s[rightSide])
            rightSide++
            max = max(max, rightSide - leftSide)
        } else {
            set.remove(s[leftSide])
            leftSide++
        }

    }
    return max

}

fun myAtoi(str: String): Int {

    val stringBuilder = StringBuilder()

    loop@ for (ss in str){

        when {
            ss == '-' && stringBuilder.isEmpty()-> stringBuilder.append(ss)
            ss == '+' && stringBuilder.isEmpty() -> stringBuilder.append(" ")
            ss.isDigit() -> stringBuilder.append(ss)
            else -> break@loop
        }
    }
    return try {
        val star = stringBuilder.toString().trim().toDouble()
        return when {
            star > Int.MAX_VALUE -> Int.MAX_VALUE
            star < Int.MIN_VALUE -> Int.MIN_VALUE
            else -> star.toInt()
        }
    } catch (ex: java.lang.NumberFormatException) {
        0
    }
}

fun maxArea(height: IntArray): Int {
    var maximum = 0
    var left = 0
    var right = height.lastIndex

    while (left < right){
        maximum = max(maximum, min(height[left], height[right]) * (right -left))
        if (height[left] < height[right]) left++ else right--
    }
    return maximum
}

