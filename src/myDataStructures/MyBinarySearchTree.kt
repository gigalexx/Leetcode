package myDataStructures

class MyBinarySearchTree() {
    var root: MyTreeNode? = null

    constructor(rootValue: Int):this() {
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
}

class MyTreeNode(value: Int) {
    val data: Int = value
    var left: MyTreeNode? = null
    var right: MyTreeNode? = null
}