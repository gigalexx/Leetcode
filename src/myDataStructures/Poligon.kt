package myDataStructures

fun main(){

    val graph = GraphBasedOnHashMap()

    graph.addNode(0)
    graph.addNode(1)
    graph.addNode(2)
    graph.addNode(3)
    graph.addNode(4)
    graph.addNode(5)
    graph.addNode(6)

    graph.addEdge(3,1)
    graph.addEdge(3,4)
    graph.addEdge(4,2)
    graph.addEdge(4,5)
    graph.addEdge(1,2)
    graph.addEdge(1,0)
    graph.addEdge(0,2)
    graph.addEdge(6,5)

    graph.showConnections()

}
