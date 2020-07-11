package problems.medium

import problems.easy.ListNode

/*
https://leetcode.com/problems/reorder-list/
143. Reorder List
Medium

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.


TC --> O(N)
SC --> O(1)

 */


fun main() {

    reorderList(ListNode(1, ListNode(2, ListNode(3, ListNode(4, null)))))

}

fun reorderList(head: ListNode?): Unit {

    if (head == null || head.next == null) return

    var slow = head
    var fast = head

    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next!!.next
    }

    var headOfSecondHalf = reverse3(slow)

    fast = head


    while (headOfSecondHalf?.next != null) {
        val tempF = fast?.next
        val tempS = headOfSecondHalf.next
        fast?.next = headOfSecondHalf
        headOfSecondHalf.next = tempF
        fast = tempF
        headOfSecondHalf = tempS
    }

    fast = head
    while (fast != null) {
        println(fast.value)
        fast = fast.next
    }
}

fun reverse3(node: ListNode?): ListNode? {

    var prev: ListNode? = null
    var curNode = node

    while (curNode != null) {

        var temp = curNode.next
        curNode.next = prev
        prev = curNode
        curNode = temp
    }

    return prev
}
