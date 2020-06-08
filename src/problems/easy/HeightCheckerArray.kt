package problems.easy

fun main() {

    print(heightChecker(intArrayOf(5, 1, 1, 2, 3, 4, 3, 3)))
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