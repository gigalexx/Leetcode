package problems.hard

import problems.easy.ListNode
import java.util.*

fun main() {

}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {

    val preHead = ListNode(-1, null)

    val queue = PriorityQueue<Int>()

    for (list in lists) {
        var curNode = list
        while (curNode != null) {
            queue.offer(curNode.value)
            curNode = curNode.next
        }
    }

    var curHead = preHead

    while (queue.isNotEmpty()) {
        curHead.next = ListNode(queue.poll(), null)
        curHead = curHead.next!!
    }


    return preHead.next
}

fun mergeKLists2(lists: Array<ListNode?>): ListNode? {

    val preHead = ListNode(-1, null)

    val comparator = Comparator<ListNode> { a, b ->
        if (a.value > b.value) 1 else -1
    }
    val queue = PriorityQueue<ListNode>(comparator)

    for (list in lists) {
        var curNode = list
        while (curNode != null) {
            queue.offer(curNode)
            curNode = curNode.next
        }
    }

    var curHead = preHead

    while (queue.isNotEmpty()) {
        curHead.next = queue.poll()
        curHead = curHead.next!!
        curHead.next = null
    }

    return preHead.next
}