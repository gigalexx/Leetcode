package myDataStructures

import java.util.*

class MyBinarySearchTree() {
    var root: MyTreeNode? = null

    constructor(rootValue: Int) : this() {
        root = MyTreeNode(rootValue)
    }

    fun insert(value: Int) {
        if (root == null) {
            root = MyTreeNode(value)
            return
        }
        val closestNode = traverseToClosestNode(value)
        when {
            value == closestNode.data -> throw Exception("No duplication allowed")

            value > closestNode.data -> closestNode.right = MyTreeNode(value)

            value < closestNode.data -> closestNode.left = MyTreeNode(value)
        }
    }


    fun lookup(value: Int) = value == traverseToClosestNode(value).data


    private fun traverseToClosestNode(value: Int): MyTreeNode {
        var currNode: MyTreeNode? = root
        while (currNode?.data != value) {
            val currData: Int = currNode?.data!!
            when {
                value > currData -> {
                    if (currNode.right != null) currNode = currNode.right else return currNode
                }
                value < currData -> {
                    if (currNode.left != null) currNode = currNode.left else return currNode
                }
            }
        }
        return currNode
    }

    fun DFSInorder(root: MyTreeNode, list: MutableList<Int>): MutableList<Int> {
        if (root.left != null) DFSInorder(root.left!!, list)
        list.add(root.data)
        if (root.right != null) DFSInorder(root.right!!, list)

        return list
    }

    fun DFSPreOrder(root: MyTreeNode, list: MutableList<Int>): MutableList<Int> {
        list.add(root.data)
        if (root.left != null) DFSPreOrder(root.left!!, list)
        if (root.right != null) DFSPreOrder(root.right!!, list)

        return list
    }

    fun DFSPostOrder(root: MyTreeNode, list: MutableList<Int>): MutableList<Int> {

        if (root.left != null) DFSPostOrder(root.left!!, list)
        if (root.right != null) DFSPostOrder(root.right!!, list)
        list.add(root.data)
        return list
    }


    fun BFS(value: Int): MyTreeNode? {

        val queue: Queue<MyTreeNode> = LinkedList<MyTreeNode>()

        queue.offer(root)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            println(node.data)
            if (node.data == value) return node
            if (node.left != null) queue.offer(node.left)
            if (node.right != null) queue.offer(node.right)
        }

        return MyTreeNode(-1)
    }
}

class MyTreeNode(value: Int) {
    val data: Int = value
    var left: MyTreeNode? = null
    var right: MyTreeNode? = null
}