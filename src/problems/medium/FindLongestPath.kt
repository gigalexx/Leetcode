package problems.medium

import kotlin.math.max

fun main() {

    val path = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
    print(lengthLongestPath(path))

}

private fun lengthLongestPath(path: String): Int {

    val paths = path.split("\n")

    val stack = IntArray(paths.size + 1)

    var maxLength = 0

    for (pathNow in paths) {

        val lev = pathNow.lastIndexOf("\t") + 1
        val curLen = stack[lev] + pathNow.length - lev + 1
        stack[lev + 1] = curLen
        if (pathNow.contains(".")) maxLength = max(maxLength, curLen - 1)

    }
    return maxLength

}