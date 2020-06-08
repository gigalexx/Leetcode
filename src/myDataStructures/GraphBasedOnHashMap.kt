package myDataStructures

import problems.medium.Node

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
            node.value.next.forEach { print("${it.value} ")}
            println()
        }
    }

}

class GraphNode(val value: Int) {
    val next = hashSetOf<GraphNode>()
}


