package problems.easy

fun main() {

    val head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6, null))))))

    middleNode(head)
}


fun middleNode(head: ListNode?): ListNode? {

    var listSize = 0

    var currNode = head

    while (currNode != null) {
        listSize++
        currNode = currNode.next
    }

    var midNode = if (listSize % 2 == 0) listSize / 2 else listSize / 2 + 1

    currNode = head

    while (--midNode > 0) {
        currNode = currNode?.next
    }

    return currNode
}
