package Algorithms.Sorting

fun main() {

    print(selectionSortingSort(intArrayOf(6, 3, 8, 1, 0, 4, 23, 6, 8, 54, 73, 6)).joinToString(" - "))
}

fun selectionSortingSort(intArray: IntArray): IntArray {

    var array = intArray
    var p1 = 0
    var indexOfMin = 0

    while (p1 < array.lastIndex) {
        for (index in p1..array.lastIndex) {
            if (array[indexOfMin] > array[index]) indexOfMin = index
        }
        val temp = array[p1]
        array[p1] = array[indexOfMin]
        array[indexOfMin] = temp
        p1++
        indexOfMin = p1
    }
    return array
}