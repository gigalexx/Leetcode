package myDataStructures

import problems.medium.Node

class QueueBasedOnLinkedList() {

    var head: ListNode? = null
    var tail: ListNode? = null

    fun push(value: Int) {
        val newNode = ListNode(value)

        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.prev = tail
            tail?.next = newNode
            tail = newNode
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