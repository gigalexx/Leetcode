package Algorithms.Sorting

fun main() {
    print(megreSort(intArrayOf(6, 3, 8, 1, 0, 4, 23, 6, 8, 54, 73, 6)).joinToString(" - "))
}

fun megreSort(intArray: IntArray): IntArray {

    if (intArray.size <= 1) return intArray


    val middle = intArray.size / 2

    var leftArr = intArray.copyOfRange(0, middle)
    var rightArr = intArray.copyOfRange(middle, intArray.size)


    return merge(megreSort(leftArr), megreSort(rightArr))
}

fun merge(leftSide: IntArray, rightSide: IntArray): IntArray {

    var arr = IntArray(leftSide.size + rightSide.size)
    var p = 0
    var pLeft = 0
    var pRight = 0

    while (pLeft < leftSide.size && pRight < rightSide.size) {

        when {
            leftSide[pLeft] < rightSide[pRight] -> arr[p++] = leftSide[pLeft++]
            rightSide[pRight] <= leftSide[pLeft] -> arr[p++] = rightSide[pRight++]
        }
    }

    if (pLeft < leftSide.size) {
        while (pLeft < leftSide.size) {
            arr[p++] = leftSide[pLeft++]
        }
    } else if (pRight < rightSide.size) {
        while (pRight < rightSide.size) {
            arr[p++] = rightSide[pRight++]
        }
    }

    return arr
}