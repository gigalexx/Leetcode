package problems.easy

import java.util.*
import kotlin.collections.HashMap


fun main() {
    val headA = ListNode(1, ListNode(2, ListNode(3, ListNode(5, ListNode(6, ListNode(7, null))))))
    val headB = ListNode(4, ListNode(9, null))
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {


    val dummyHead = ListNode(0,null)
    var p: ListNode? = l1
    var q: ListNode? = l2
    var curr: ListNode? = dummyHead
    var carry = 0
    while (p != null || q != null) {
        val x = if (p != null) p.value else 0
        val y = if (q != null) q.value else 0
        val sum = carry + x + y
        carry = sum / 10
        curr!!.next = ListNode(sum % 10,null)
        curr = curr!!.next
        if (p != null) p = p.next
        if (q != null) q = q.next
    }
    if (carry > 0) {
        curr!!.next = ListNode(carry, null)
    }
    return dummyHead.next
}





fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

    val preHead = ListNode(-1, null)
    var listOne = l1
    var listTwo = l2

    var prev: ListNode? = preHead
    while (listOne != null && listTwo != null) {
        if (listOne.value <= listTwo.value) {
            prev?.next = listOne
            listOne = listOne.next
        } else {
            prev?.next = listTwo
            listTwo = listTwo.next
        }
        prev = prev?.next
    }

    prev?.next = listOne ?: listTwo

    return preHead.next
}


fun hasCycle(head: ListNode?): Int? {

    var node = head
    val nodesSeen: HashMap<ListNode, Int> = HashMap()
    while (node != null) {
        if (nodesSeen.contains(node)) {
            return nodesSeen[node]
        } else {
            //  nodesSeen.add(node)
        }
        node = node.next
    }
    return null
}

fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {

    val set = mutableSetOf<ListNode>()

    var headOne = headA
    var headTwo = headB

    while (headOne != null) {
        set.add(headOne)
        headOne = headOne.next
    }

    while (headTwo != null) {
        if (set.contains(headTwo)) return headTwo else headTwo = headTwo.next

    }

    return null
}

fun reverseList(head: ListNode?): ListNode? {

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

fun removeElements(head: ListNode?, value: Int): ListNode? {

    var prev: ListNode? = null
    var curr = head
    if (curr?.value == value) return curr.next

    while (curr != null) {
        if (curr.value != value) {
            prev = curr
            curr = curr.next
        } else {
            prev?.next = curr.next
            break
        }
    }
    return prev
}

fun oddEvenList(head: ListNode?): ListNode? {

    if (head == null) return null
    var odd = head
    var even = head.next
    val evenHead = even
    while (even != null && even.next != null) {
        odd?.next = even.next
        odd = odd?.next
        even.next = odd?.next
        even = even.next
    }
    odd?.next = evenHead

    return head
}

fun isPalindrome(head: ListNode?): Boolean {

    val arrayList = arrayListOf<Int>()
    var currNode: ListNode? = head
    while (currNode != null) {
        arrayList.add(currNode.value)
        currNode = currNode.next
    }
    var rightIndex = arrayList.size - 1
    var leftIndex = 0
    while (leftIndex < rightIndex) {
        if (arrayList[leftIndex] != arrayList[rightIndex]) return false
        leftIndex++
        rightIndex--
    }

    return true
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var node = head

    var listLength = 0

    while (node != null) {
        listLength++
        node = node.next
    }

    if (listLength - 1 == n) return head?.next
    val elementIndex = listLength - n + 1
    var index = 0
    node = head

    while (index < elementIndex - 2) {
        node = node?.next
        index++
    }
    if (node?.next?.next != null) {
        node.next = node?.next?.next
    } else {
        node?.next = null
    }
    return head
}

data class ListNode(var value: Int, var next: ListNode?)