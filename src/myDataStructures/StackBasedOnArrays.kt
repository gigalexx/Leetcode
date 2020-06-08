package myDataStructures

import problems.medium.Node

class StackBasedOnArrays() {

    private val data = arrayListOf<ListNode>()


    fun push(value: Int) {
        data.add(ListNode(value))
    }

    fun peek(): Int? {
        return if(data.isEmpty()) null else data.last().value
    }

    fun pop(): Int? {

        if (data.isEmpty()) return null

        val lastNodeValue = data.last().value
        data.removeAt(data.lastIndex)
        return lastNodeValue

    }

}