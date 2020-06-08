package myDataStructures

class MyLinkedList(headElement: Int) {
    var headNode = MyNode(headElement, null, null)
    var tail = this.headNode
    var length = 1

    fun insert(value: Int, index: Int) {
        when {
            index >= length -> throw IndexOutOfBoundsException("Index bigger then list size")
            index == length - 1 -> append(value)
            index < length - 1 -> {
                var leader = traverseToNode(index - 1)
                val newNode = MyNode(value, leader.next, leader)
                leader.next = newNode
                newNode.prevous = leader
                length++
            }
        }
    }

    fun reverse() {
        var leader = headNode
        while (true) {
            val tempNext = leader.next
            leader.next = leader.prevous
            leader.prevous = tempNext
            if (tempNext != null) leader = tempNext!! else break
        }
        val tempHead = headNode
        headNode = tail
        tail = tempHead
        println("Head value: ${headNode.data}")
        println("Tail value: ${tail.data}")

    }

    fun reverse2() {
        var leader = headNode
        var current = leader.next
        leader.next = null
        while (current != null) {
            val nextCurrent = current.next
            current.next = leader
            leader = current
            current = nextCurrent
        }
        val tempHead = headNode
        headNode = tail
        tail = tempHead
        println("Head value: ${headNode.data}")
        println("Tail value: ${tail.data}")

    }

    fun remove(index: Int) {
        when {
            index >= length -> throw IndexOutOfBoundsException("Index bigger then list size")
            index == length - 1 -> {
                var leader = traverseToNode(index - 1)
                leader.next = null
                tail.prevous = null
                tail = leader
                length--
            }
            index < length - 1 -> {
                var leader = traverseToNode(index - 1)
                var unwantedNode = leader.next
                leader.next = unwantedNode?.next
                length--
            }
        }
    }

    private fun traverseToNode(index: Int): MyNode {
        var counter = 0
        var currNode = headNode
        while (counter < index) {
            currNode = currNode.next!!
            counter++
        }
        return currNode
    }

    fun append(value: Int) {
        val newNode = MyNode(value, null, tail)
        if (headNode.next == null) {
            headNode.next = newNode
            newNode.prevous = headNode
        } else {
            var leader = traverseToNode(length - 1)
            leader.next = newNode
            newNode.prevous = leader
        }

        tail = newNode
        length++
    }


    fun prepend(value: Int) {
        val newNode = MyNode(value, headNode, null)
        headNode.prevous = newNode
        headNode = newNode
        length++
    }

    override fun toString(): String {
        var answer = headNode.data.toString()
        var lastNode = headNode
        while (lastNode.next != null) {
            lastNode = lastNode.next!!
            answer += ", ${lastNode.data}"
        }
        return answer
    }

    fun size(): Int {
        return length
    }
}

class MyNode(value: Int, next: MyNode?, prev: MyNode?) {
    val data: Int = value
    var next = next
    var prevous = prev
}