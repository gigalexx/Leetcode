package myDataStructures

import problems.medium.Node

class StackBasedOnLinkedList() {

    var head: ListNode? = null
    
    fun push(value: Int) {
        val newNode = ListNode(value)

        if (head == null) {
            head = newNode
        } else {
            newNode.next = head
            head = newNode
        }
    }

    fun peek(): Int? {
        return if (head == null) null else head?.value
    }

    fun pop(): Int? {
        return if (head == null) {
            null
        } else {
            val value = head?.value
            head = head?.next
            value
        }

    }

}