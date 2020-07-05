package problems.easy

/*
https://leetcode.com/problems/linked-list-cycle/
141. Linked List Cycle
Easy

Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

 TC -> O(N)
 SC -> (1) using fast-slow pointers approach and (N) using HashSet


 If we want to find circle length  we need to using fast-slow pointers approach find place where they intersect. Mark this place like a start and then iterate further until we came to this place again.

 */
fun main() {


}

fun hasCycle2(head: ListNode?): Boolean {

    var first = head
    var second = head

    var counter = 0

    while (first?.next != null) {
        first = first.next

        if (first == second) return true

        if (counter > 1) {
            second = second?.next
            counter--
        } else counter++

    }
    return false
}
