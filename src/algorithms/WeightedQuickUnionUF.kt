package algorithms

class WeightedQuickUnionUF(private var count: Int) {
    private val parent: IntArray = IntArray(count)
    private val size: IntArray = IntArray(count)

    /**
     * Initializes an empty union-find data structure with
     * `n` elements `0` through `n-1`.
     * Initially, each elements is in its own set.
     *
     * @param  n the number of elements
     * @throws IllegalArgumentException if `n < 0`
     */
    init {
        for (i in 0 until count) {
            parent[i] = i
            size[i] = 1
        }
    }

    /**
     * Returns the number of sets.
     *
     * @return the number of sets (between `1` and `n`)
     */
    fun getCount(): Int {
        return count
    }

    /**
     * Returns the canonical element of the set containing element `p`.
     *
     * @param  p an element
     * @return the canonical element of the set containing `p`
     * @throws IllegalArgumentException unless `0 <= p < n`
     */
    fun find(p: Int): Int {
        var p = p
        validate(p)
        while (p != parent[p]) p = parent[p]
        return p
    }

    /**
     * Returns true if the two elements are in the same set.
     *
     * @param  p one element
     * @param  q the other element
     * @return `true` if `p` and `q` are in the same set;
     * `false` otherwise
     * @throws IllegalArgumentException unless
     * both `0 <= p < n` and `0 <= q < n`
     */
    fun connected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    // validate that p is a valid index
    private fun validate(p: Int) {
        val n = parent.size
        require(!(p < 0 || p >= n)) { "index " + p + " is not between 0 and " + (n - 1) }
    }

    /**
     * Merges the set containing element `p` with the
     * the set containing element `q`.
     *
     * @param  p one element
     * @param  q the other element
     * @throws IllegalArgumentException unless
     * both `0 <= p < n` and `0 <= q < n`
     */
    fun union(p: Int, q: Int) {
        val rootP = find(p)
        val rootQ = find(q)
        if (rootP == rootQ) return

        // make smaller root point to larger one
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