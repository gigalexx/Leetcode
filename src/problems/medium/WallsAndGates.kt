package problems.medium

fun main() {
//    var list = arrayOf(intArrayOf(2147483647,-1,0,2147483647), intArrayOf(2147483647,2147483647,2147483647,-1), intArrayOf(2147483647,-1,2147483647,-1), intArrayOf(0,-1,2147483647,2147483647))
//    wallsAndGates(list)
//    println(getFactorialIteratively(30))
 //   println(getFactorialRecursively(30))
    println(getFibonacciIteratively(5))


}

fun wallsAndGates(rooms: Array<IntArray>): Unit {

    for (rowIndex in rooms.indices) {
        for (colIndex in rooms[rowIndex].indices) {
            if (rooms[rowIndex][colIndex] == 0) {
                dfs(rowIndex, colIndex, 0, rooms)
            }
        }
    }


}

fun dfs(rowIndex: Int, colIndex: Int, counter: Int, rooms: Array<IntArray>) {

    if (rowIndex < 0 || rowIndex >= rooms.size || colIndex < 0 || colIndex >= rooms[rowIndex].size || rooms[rowIndex][colIndex] < counter) {
        return
    }

    rooms[rowIndex][colIndex] = counter

    dfs(rowIndex + 1, colIndex, counter + 1, rooms)
    dfs(rowIndex - 1, colIndex, counter + 1, rooms)
    dfs(rowIndex, colIndex + 1, counter + 1, rooms)
    dfs(rowIndex, colIndex - 1, counter + 1, rooms)

}


fun callRecursive(counter: Int): String {
    println(counter)
    if (counter > 10520) {
        return "Done"
    }

    return callRecursive(counter + 1)
}

fun getFactorialRecursively(number: Int): Int {
    if (number == 1) {
        return number
    }

    return getFactorialRecursively(number - 1) * number
}

fun getFactorialIteratively(number: Int): Int {
    var sum = 1
    for (num in number downTo 1) {
        sum *= num
    }
    return sum
}

fun getFibonacciRecursively(index: Int): Int {
    if (index == 1) {
        return index
    }

    return getFactorialRecursively(index - 1) * index
}

fun getFibonacciIteratively(index: Int): Int {

    var prev = 1
    var curr = 1
    for (num in 1..index) {
        curr += prev
        prev = curr - prev

        if (num == index) return curr
    }
    return -1
}