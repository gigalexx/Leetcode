package Algorithms

import java.util.*
import kotlin.collections.ArrayList


fun main() {
    val queue : Queue<Int> = LinkedList<Int>()

    var counter = 0

    var sum = queue.sumByDouble { it.toDouble() }

    queue.offer(1)
    queue.offer(4)
    queue.offer(8)
    queue.offer(2)
    queue.offer(9)
    queue.offer(5)
    queue.offer(3)
    queue.offer(6)
    queue.offer(11)

    while (queue.isNotEmpty()){
        println(queue.poll())
    }


}

fun preorderTraversal(root: TreeNode?): List<Int> {  //Time and Space = O(n)

    val list = mutableListOf<Int>()
    val stack = mutableListOf<TreeNode>()
    stack.add(root!!)

    while (stack.isNotEmpty()) {
        val treeNode = stack.last()
        stack.remove(treeNode)
        list.add(treeNode.value)

        if (treeNode.right != null) {
            stack.add(treeNode.right!!)
        }
        if (treeNode.left != null) {
            stack.add(treeNode.left!!)
        }
    }

    return list
}

fun inorderTraversal(root: TreeNode?): List<Int> {   // Iterative approach    //Time and Space = O(n)
    val list = mutableListOf<Int>()
    val stack = Stack<TreeNode>()

    var currNode = root

    while (currNode != null || stack.isNotEmpty()) {
        while (currNode != null) {
            stack.push(currNode)
            currNode = currNode.left
        }
        currNode = stack.pop()
        list.add(currNode.value)
        currNode = currNode.right
    }

    return list
}

fun inorderTraversalRecursive(root: TreeNode?): List<Int>? { // Recursive approach  //Time and Space = O(n)
    val res = mutableListOf<Int>()
    helper(root, res)
    return res
}

fun helper(root: TreeNode?, res: MutableList<Int>) {
    if (root != null) {
        if (root.left != null) {
            helper(root.left, res)
        }
        res.add(root.value)
        if (root.right != null) {
            helper(root.right, res)
        }
    }
}

fun postorderTraversal(root: TreeNode?): List<Int> {

    val ans = mutableListOf<Int>()
    val stack = Stack<TreeNode?>()
    if (root == null) return ans

    stack.push(root)
    while (!stack.isEmpty()) {
        val cur = stack.pop()
        ans.add(0, cur?.value!!)
        if (cur!!.left != null) {
            stack.push(cur!!.left)
        }
        if (cur!!.right != null) {
            stack.push(cur!!.right)
        }
    }
    return ans

}

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class MyCircularQueue(k: Int) {

    private val maxSize = k
    private val data = ArrayList<Int>(k)


    /** Insert an element into the circular queue. Return true if the operation is successful. */
    fun enQueue(value: Int): Boolean {
        if (!isFull()) {
            data.add(value)
            return true
        }
        return false
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    fun deQueue(): Boolean {
        if (!isEmpty()) {
            data.remove(data.first())
            return true
        }
        return false
    }

    /** Get the front item from the queue. */
    fun Front(): Int {
        if (!isEmpty()) {
            return data.first()
        }
        return -1
    }

    /** Get the last item from the queue. */
    fun Rear(): Int {
        if (!isEmpty()) {
            return data.last()
        }
        return -1
    }

    /** Checks whether the circular queue is empty or not. */
     fun isEmpty(): Boolean = data.isEmpty()

    /** Checks whether the circular queue is full or not. */
     fun isFull(): Boolean = data.size == maxSize

}