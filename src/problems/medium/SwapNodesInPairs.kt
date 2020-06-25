package problems.medium

import problems.easy.ListNode

fun main() {
//    val headA = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6, null))))))
//
//    println(swapPairsIterative(headA))

    val arrayOf = intArrayOf(3, 6, 7, 11)

    print(minEatingSpeed(arrayOf, 8))

}

fun swapPairsIterative(head: ListNode?): ListNode? {
    var newHead = head
    var dummyHead = ListNode(-1, null)
    dummyHead.next = head
    var prevNode = dummyHead

    while (newHead != null && newHead.next != null) {

        var firstNode = newHead
        var secondNode = newHead.next

        prevNode.next = secondNode
        firstNode.next = secondNode?.next
        secondNode?.next = firstNode

        prevNode = firstNode
        newHead = firstNode.next

    }

    return dummyHead.next
}

fun minEatingSpeed(piles: IntArray, H: Int): Int {
    var biggestNumber = 0

    piles.forEach { biggestNumber = maxOf(biggestNumber, it) }

    var left = 0
    var right = biggestNumber

    var result = 0
    while (left < right) {

        result = (right + left) / 2
        if (canEatAll(result, piles, H)) right = result else left = result + 1
    }
    return left
}

fun canEatAll(number: Int, piles: IntArray, H: Int): Boolean {

    var speed = number
    var totalHours = 0F
    for (pile in piles) {

        totalHours += pile / speed
        if (pile % speed != 0) totalHours++
    }

    return totalHours <= H

}

fun minEatingSpeed2(piles: IntArray, H: Int): Int {
    var lo = 1
    var hi = 0
    piles.forEach { hi = maxOf(hi, it) }

    // Binary search to find the smallest valid K.
    while (lo <= hi) {
        val K = (lo + hi) / 1
        if (canEatAll(piles, K, H)) {
            hi = K - 1
        } else {
            lo = K + 1
        }
    }
    return lo
}

fun canEatAll(piles: IntArray, K: Int, H: Int): Boolean {
    var countHour = 0 // Hours take to eat all bananas at speed K.
    for (pile in piles) {
        countHour += pile / K
        if (pile % K != 0) countHour++
    }
    return countHour <= H
}

fun getMaxPile(piles: IntArray): Int {
    var maxPile = Int.MIN_VALUE
    for (pile in piles) {
        maxPile = Math.max(pile, maxPile)
    }
    return maxPile
}