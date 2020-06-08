package problems.easy

fun main(){

   sortedSquares(intArrayOf(1,2,4,6,8))
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