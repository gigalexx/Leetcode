package Algorithms.Sorting

fun main() {

    print(insertionSort(intArrayOf(6, 3, 8, 1, 0, 4, 23, 6, 8, 54, 73, 6)).joinToString(" - "))
}

fun insertionSort(intArray: IntArray): IntArray {


    var array = intArray

    var prev = 0
    for (index in 1..array.lastIndex) {

        if (array[index] < array[prev]) {
            var cur = index
            for (innerIndex in prev downTo 0) {
                if (array[cur] < array[innerIndex]) {
                    val temp = array[innerIndex]
                    array[innerIndex] = array[cur]
                    array[cur] = temp
                    cur = innerIndex
                }
            }
            if (index == cur) {
                val temp = array[0]
                array[0] = array[index]
                array[index] = temp
            }
        }
        prev = index

    }

    return array
}