package problems.medium

fun main() {


    val arrayOf = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'), charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'), charArrayOf('0', '0', '0', '0', '0')
    )

    numIslands(arrayOf)

}

fun numIslands(grid: Array<CharArray>): Int {

    var numOfIslands = 0
    for (rowIndex in grid.indices) {
        for (colIndex in grid[rowIndex].indices) {

            if (grid[rowIndex][colIndex] == '1') {
                numOfIslands++
                dfs(rowIndex, colIndex, grid)
            }

        }
    }


    return numOfIslands
}

fun dfs(rowIndex: Int, colIndex: Int, grid: Array<CharArray>) {

    if (rowIndex < 0 || rowIndex >= grid.size || colIndex < 0 || colIndex >= grid[rowIndex].size || grid[rowIndex][colIndex] == '0') {
        return
    }

    grid[rowIndex][colIndex] = '0'

    dfs(rowIndex + 1, colIndex, grid)
    dfs(rowIndex - 1, colIndex, grid)
    dfs(rowIndex, colIndex + 1, grid)
    dfs(rowIndex, colIndex - 1, grid)
}
