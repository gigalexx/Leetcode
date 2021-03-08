package algorithms

/* "p" and "q" are connected if they have the same ID
 Too slow. Take quadratic time to make all union operations
 TC O(N^2)
 Cons:
 Union too expensive( N array access)
 Tree are flat but it too expensive to keep them flat
 */
class QuickFindUF(N: Int) {

    private var arr: IntArray = IntArray(N)

    init {
        for (i in 0 until N) arr[i] = i
    }


    fun isConnected(p: Int, q: Int): Boolean {
        return arr[p] == arr[q]
    }

    fun union(p: Int, q: Int) {
        val pid = arr[p]
        val qid = arr[q]
        for (i in arr.indices) {
            if (arr[i] == pid) arr[i] = qid
        }
    }
}