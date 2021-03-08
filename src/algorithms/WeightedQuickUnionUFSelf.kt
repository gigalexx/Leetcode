package algorithms

class WeightedQuickUnionUFSelf(private var count: Int) {
    private val parent = IntArray(count)
    val size = IntArray(count)


    init {
        for (num in 0 until count) {
            parent[num] = num
            size[num] = 1
        }
    }

    private fun getCount() = count

    private fun find(p: Int): Int {
        var p = p

        validate(p)

        while (p != parent[p]) p = parent[p]
        return p
    }

    private fun validate(p: Int) {
        val n = parent.size
        require(p > -1 && p <= n)
    }


    fun isConnected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }


    fun union(p: Int, q: Int) {

        val rootP = find(p)
        val rootQ = find(q)

        if (rootP == rootQ) return

        if (size[rootP] < size[rootQ]) {

            parent[rootP] = rootQ
            size[rootQ] += size[rootP]

        } else {
            parent[rootQ] = rootP
            size[rootP] += size[rootQ]
        }
        count--
    }

}