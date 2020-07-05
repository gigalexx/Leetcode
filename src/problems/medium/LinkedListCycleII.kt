package problems.medium

/*
https://leetcode.com/problems/linked-list-cycle-ii/

142. Linked List Cycle II
Medium

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.

TC -> O(N)
SC -> using HashSet O(N)
SC -> withOut HashSet O(1)

 */


fun main() {

    val head = ListNode2(1)
    head.next = ListNode2(2)
    head.next!!.next = ListNode2(3)
    head.next!!.next!!.next = ListNode2(4)
    head.next!!.next!!.next!!.next = ListNode2(5)
    head.next!!.next!!.next!!.next!!.next = ListNode2(6)

    head.next!!.next?.next?.next?.next?.next = head.next!!.next



    detectCycle2(head)

}

fun detectCycle(head: ListNode2?): ListNode2? {     //<-- using HashSet which make SC -> O(N)

    if (head == null) return null
    val seen = hashSetOf<ListNode2>()

    var p1 = head
    seen.add(p1)

    while (p1?.next != null) {
        p1 = p1.next
        if (seen.contains(p1)) return p1 else seen.add(p1!!)
    }

    return null
}

fun detectCycle2(head: ListNode2?): ListNode2? {

    if (head == null) return null

    var fast = head
    var slow = head
    var counter = 0


    while (fast?.next != null) {

        fast = fast.next

        if (fast == slow) break

        if (counter > 1) {
            slow = slow?.next
            counter--
        } else counter++

    }

    if (fast?.next == null) return null

    counter = 1
    fast = fast.next
    while (fast != slow) {
        fast = fast?.next
        counter++
    }

    fast = head
    slow = head

    while (counter != 0) {
        fast = fast?.next
        counter--
    }

    while (fast != slow) {
        fast = fast?.next
        slow = slow?.next
    }

    return fast
}

data class ListNode2(var value: Int) {
    var next: ListNode2? = null
}