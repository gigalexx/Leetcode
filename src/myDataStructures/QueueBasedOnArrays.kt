package myDataStructures

import com.sun.source.tree.BinaryTree
import problems.medium.Node
import java.util.*

class QueueBasedOnArrays() {

    private val data = arrayListOf<ListNode>()


    private val stack = Stack<Int>()

    fun push(value: Int) {
        data.add(ListNode(value))
        stack.firstElement()


    }

    fun peek(): Int? {

        return if(data.isEmpty()) null else data.first().value
    }

    fun pop(): Int? {

        if (data.isEmpty()) return null

        val firstNodeValue = data.first().value
        data.removeAt(0)
        return firstNodeValue

    }

}