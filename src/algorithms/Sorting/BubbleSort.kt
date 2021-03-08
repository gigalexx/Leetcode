package algorithms.Sorting

fun main() {

    print(bubbleSort(intArrayOf(6, 3, 8, 1, 0, 4, 23, 6, 8, 54, 73, 6)).joinToString(" - "))
}

fun bubbleSort(intArray: IntArray): IntArray {

    var array = intArray
    var lastIndex = array.lastIndex


    while (lastIndex > 0) {
        for (index in 1..lastIndex) {
            if (array[index] < array[index - 1]) {
                val temp = array[index - 1]
                array[index - 1] = array[index]
                array[index] = temp
            }
        }
        lastIndex--
    }
    return array
}