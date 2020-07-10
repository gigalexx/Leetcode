package problems.easy
/*
https://leetcode.com/problems/palindrome-linked-list/

234. Palindrome Linked List
Easy

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?


TC -> O(N)
SC -> O(1)

 */

fun main() {

    println(isPalindrome2(ListNode(0, ListNode(0, null))))
}

fun isPalindrome2(_head: ListNode?): Boolean {

    var head = _head
    if (head == null || head.next == null) return true

    var fast = head
    var slow = head


    while (fast != null && fast.next != null) {
        fast = fast.next!!.next
        slow = slow?.next
    }


    var headSecondHalf = reverse(slow)
    val copyOfSecondHalf = headSecondHalf


    while (head != null && headSecondHalf != null) {
        if (head.value != headSecondHalf.value) return false

        head = head.next
        headSecondHalf = headSecondHalf.next
    }

    reverse(copyOfSecondHalf)

    if (head == null || headSecondHalf == null) return true

    return false
}

fun reverse(head: ListNode?): ListNode? {

    var prev: ListNode? = null
    var curr = head
    while (curr != null) {
        val nextTemp = curr.next
        curr.next = prev
        prev = curr
        curr = nextTemp
    }
    return prev
}