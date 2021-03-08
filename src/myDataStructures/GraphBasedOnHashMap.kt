package myDataStructures

class GraphBasedOnHashMap {

    var numberOfNodes = 0
    private val adjacentList = hashMapOf<Int, GraphNode>()


    fun addNode(value: Int) {
        adjacentList.put(value, GraphNode(value))
        numberOfNodes++
    }

    fun addEdge(value1: Int, value2: Int) {
        if (adjacentList.containsKey(value1) && adjacentList.containsKey(value2)) {
            adjacentList[value1]?.next?.add(adjacentList[value2]!!)
            adjacentList[value2]?.next?.add(adjacentList[value1]!!)
        }
    }

    fun showConnections() {
        for (node in adjacentList) {
            print("${node.key} --> ")
            node.value.next.forEach { print("${it.value} ") }
            println()
        }
    }

    fun test() {
        val input = "Welcome to the bank"

        val hashMap = HashMap<Char, Int>()

        for (str in input) {
            if (hashMap[str] != null) hashMap[str] = hashMap[str]!!.plus(1) else hashMap[str] = 1
        }


        hashMap.forEach {
            if (it.value > 1) print("${it.key}${it.value}")
        }
    }

}

class GraphNode(val value: Int) {
    val next = hashSetOf<GraphNode>()
}


