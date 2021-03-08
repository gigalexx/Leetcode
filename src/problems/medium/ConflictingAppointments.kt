package problems.medium

fun main() {


    val list =
        listOf<IntArray>(intArrayOf(4, 5), intArrayOf(2, 3), intArrayOf(3, 6), intArrayOf(5, 7), intArrayOf(7, 8))

    //  print(canAttendAllAppointments(list))

    println(
        findAllConflictedAppointments(list).iterator()
            .forEach { println("${it.first.first()}:${it.first.last()} , ${it.second.first()}:${it.second.last()}") })

}


fun findAllConflictedAppointments(intervals: List<IntArray>): MutableList<Pair<IntArray, IntArray>> {

    var list = intervals.sortedBy { it.first() }

    var conflicts = mutableListOf<Pair<IntArray, IntArray>>()

    var pointer = 0

    while (pointer < list.lastIndex) {
        if (list[pointer].last() > list[pointer + 1].first()) conflicts.add(Pair(list[pointer], list[pointer + 1]))
        pointer++
    }

    return conflicts
}