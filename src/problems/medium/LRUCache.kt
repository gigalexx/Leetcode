package problems.medium

import java.util.*


fun main() {


    val lruCache = LRUCache(5)
    lruCache.put(1, 1)
    lruCache.put(2, 2)
    lruCache.put(3, 3)
    lruCache.put(4, 4)
    lruCache.put(5, 5)
    println(lruCache.get(1))
    lruCache.put(6, 6)
    println(lruCache.get(1))
    println(lruCache.get(2))

}


class LRUCache(private val capacity: Int) {
    private val ll = LinkedList<Node>()
    private val map = HashMap<Int, Node>()

    class Node(var key: Int, var value: Int)


    fun get(key: Int): Int {
        return if (map.containsKey(key)) {
            val node = map[key]
            ll.remove(node)
            ll.addFirst(node)
            node!!.value
        } else {
            -1
        }
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            val old = map[key]
            old!!.value = value
            ll.remove(old)
            ll.addFirst(old)
        } else {
            val created = Node(key, value)
            if (map.size >= capacity) {
                map.remove(ll.last!!.key)
                ll.removeLast()
            }
            ll.addFirst(created)
            map[key] = created
        }
    }
}
