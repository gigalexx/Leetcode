package problems.medium

fun main() {


    var list = arrayOf(
        intArrayOf(2147483647, -1, 0, 2147483647),
        intArrayOf(2147483647, 2147483647, 2147483647, -1),
        intArrayOf(2147483647, -1, 2147483647, -1),
        intArrayOf(0, -1, 2147483647, 2147483647)
    )
    wallsAndGatesDFS(list)
}


fun wallsAndGatesBFS(rooms: Array<IntArray>): Unit {


    for (rowIndex in rooms.indices) {
        for (colIndex in rooms[rowIndex].indices) {
            if (rooms[rowIndex][colIndex] == 0) {
                dfs(rowIndex, colIndex, 0, rooms)
            }
        }
    }


}


fun wallsAndGatesDFS(rooms: Array<IntArray>): Unit {

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



