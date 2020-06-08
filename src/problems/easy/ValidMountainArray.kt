package problems.easy

fun main() {

    val ints = intArrayOf(1, 3, 2)

    print(validMountainArray(ints))
}

fun validMountainArray(A: IntArray): Boolean {

    if (A.size < 3) return false

    var p1 = 0
    var p2 = A.lastIndex

    while (p1 + 1 < p2 && A[p1 + 1] > A[p1]) {
        p1++
    }
    if (p1 == 0 || p1 == p2) return false

    while (p2 > 0 && A[p2] < A[p2 - 1]) {
        p2--
    }

    return p1 == p2

}