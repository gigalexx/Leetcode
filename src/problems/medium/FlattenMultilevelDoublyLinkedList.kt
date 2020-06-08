package problems.medium

import problems.easy.ListNode
import java.util.*

fun main() {
    var A = Node(1)
    var B = Node(3)
    var C = Node(5)
    A.next = B
    B.next = C
    C.next = A

    val headA = problems.easy.ListNode(
        1,
        problems.easy.ListNode(
            2,
            problems.easy.ListNode(
                3,
                problems.easy.ListNode(4, problems.easy.ListNode(5, null))
            )
        )
    )

    rotateRight(headA, 6)
}

fun flatten(root: Node?): Node? {
    val stack = Stack<Node>()

    var currNode = root

    var char  = 'c'
    char.isLetter()

    while (currNode != null || !stack.empty()) {

        if (currNode?.child != null) {
            if (currNode.next != null) stack.push(currNode.next)
            currNode.next = currNode.child
            currNode.next?.prev = currNode
            currNode.child = null
        }

        if (currNode?.next == null && !stack.isEmpty()) {
            currNode?.next = stack.pop()
            currNode?.next?.prev = currNode
        }
        currNode = currNode?.next
    }

    return root
}

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
    var random: Node? = null
}

fun insert(head: Node?, insertVal: Int): Node? {
    if (head == null) {
        val newNode = Node(insertVal)
        newNode.next = newNode
        return newNode
    }
    var prev = head
    var curr = head.next
    var toInsert = false
    do {
        if (prev!!.`val` <= insertVal && insertVal <= curr!!.`val`) {
            // Case 1).
            toInsert = true
        } else if (prev.`val` > curr!!.`val`) {
            // Case 2).
            if (insertVal >= prev.`val` || insertVal <= curr.`val`) toInsert = true
        }
        if (toInsert) {
            prev.next = Node(insertVal)
            prev.next?.next = curr
            return head
        }
        prev = curr
        curr = curr.next
    } while (prev != head)

    // Case 3).
    prev.next = Node(insertVal)
    prev.next?.next = curr
    return head
}

fun copyRandomList(node: Node?): Node? {

    val map = HashMap<Int, Node>()

    val preHead= Node(0)
    var currNode = node
    var index = 0
    while(currNode != null) {
        map.put(index, Node(currNode.`val`))
        currNode = currNode.next
        index++
    }

    currNode = node
    var currNewNode: Node? = preHead
    index = 0
    while(currNode != null) {
        currNewNode?.next = map[index]
        if(currNode.random != null){
            val value: Int? =  currNode?.random?.`val`
            currNewNode?.next?.random =  map[value]
        }
        currNewNode = currNewNode?.next
        currNode = currNode.next
        index++
    }

    return preHead?.next
}

fun rotateRight(head: ListNode?, k: Int): ListNode? {

    if (head?.next == null) return head
    var hh = head
    var currNode = hh
    var listLength = 0
    while (currNode != null) {
        listLength++
        currNode = currNode.next
    }

    var shiftTimes = k
    if (k > listLength) {
        shiftTimes = k % listLength
    }


    repeat(shiftTimes) {
        var currNode = hh
        var prev = hh
        while (currNode?.next != null) {
            prev = currNode
            currNode = currNode?.next
        }
        val lastNode = prev?.next
        prev?.next = null
        lastNode?.next = hh
        hh = lastNode
    }

    return hh
}