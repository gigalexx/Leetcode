package problems.easy

fun main(){

   print(sortedSquares2(intArrayOf(1,2,4,6,8)).joinToString(","))
}
fun sortedSquares(A: IntArray): IntArray {
    val array = IntArray(A.size)
    var indexEnd = A.lastIndex
    var indexStart = 0
    var arrayIndex = indexEnd

    while (indexEnd >= indexStart) {
        val stResult = A[indexStart] * A[indexStart]
        val endResult = A[indexEnd] * A[indexEnd]
        if (stResult > endResult) {
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

fun sortedSquares2(A: IntArray): IntArray {

    val array = IntArray(A.size)
    var p1 = 0
    var p2 = A.lastIndex
    var arrayIndex = p2

    while (p1 < p2){

        val p1s = A[p1] * A[p1]
        val p2s = A[p2] * A[p2]

        if(p1s > p2s) {
            array[arrayIndex--] = p1s
            p1++
        } else {
            array[arrayIndex--] = p2s
            p2--
        }

    }
    return array
}