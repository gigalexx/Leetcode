package myDataStructures

class MyLinkedList2() {

    private var head: ListNode? = null
    private var tail: ListNode? = null
    var lenght = 0


    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int? {
        return when (index) {
            !in 0..lenght -> -1
            lenght -> tail?.value
            0 -> head?.value
            else -> getLeadElement(index)?.next?.value
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(value: Int) {
        val newNode = ListNode(value)
        if (head == null) tail = newNode else newNode.next = head
        head = newNode
        lenght++
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(value: Int) {
        val newNode = ListNode(value)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
        }
        tail = newNode
        lenght++
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, value: Int) {
        when (index) {
            !in 0..lenght -> return
            lenght -> addAtTail(value)
            0 -> addAtHead(value)
            else -> {
                val leadNode = getLeadElement(index)
                val newNode = ListNode(value)
                newNode.next = leadNode?.next
                leadNode?.next = newNode
                lenght++
            }
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        when (index) {
            !in 0..lenght -> return
            lenght -> {
                val leadNode = getLeadElement(index)
                leadNode?.next = null
                tail = leadNode
            }
            0 -> {
                head = head?.next
            }
            else -> {
                val leadNode = getLeadElement(index)
                leadNode?.next = leadNode?.next?.next
            }
        }
        lenght--

    }

    fun getLeadElement(index: Int): ListNode? {
        var counter = 1
        var curNode = head
        while (counter < index) {
            curNode = curNode?.next!!
            counter++
        }
        return curNode
    }

}


class ListNode(x: Int) {
    var value = x
    var next: ListNode? = null
    var prev: ListNode? = null
}