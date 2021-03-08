package algorithms

/*
Represent data like trees
Make union operation only for roots
Ask each element about it's ID(or parent) and if element has same ID as it's value (or parent by itself)
that mean this element is a root

TC O(N^2)
Cons:
Trees can get tall
Find to expensive (could be N array accesses)

 */
class QuickUnionUF(N: Int) {

    private var arr: IntArray = IntArray(N)

    init {
        for (i in 0 until N) arr[i] = i
    }

    private fun getRoot(i: Int): Int {
        var currElement = i
        while (currElement != arr[currElement]) {
            currElement = arr[currElement]
        }
        return currElement
    }

    fun isConnected(p: Int, q: Int): Boolean {
        return getRoot(p) == getRoot(q)
    }

    fun union(p: Int, q: Int) {
        val pid = getRoot(p)
        val qid = getRoot(q)
        arr[pid] = qid
    }
}