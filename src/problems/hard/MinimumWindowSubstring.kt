package problems.hard

import java.util.*


fun main() {

    print(minWindow("ADOBECODEBANC", "ABC"))

}

fun minWindow(input: String, pattern: String): String {

    var ans = input + pattern
    val map = hashMapOf<Char, Int>()
    var matched = 0
    var left = 0
    var right = 0

    for (ch in pattern) {
        if (map.containsKey(ch)) map[ch] = map[ch]!! + 1 else map[ch] = 1
    }

    while (right < input.length) {
        val ch = input[right]

        if (map.containsKey(ch)) {
            map[ch] = map[ch]!! - 1
            if (map[ch]!! == 0) matched++
        }


        while (matched >= map.size) {
            val sub = input.substring(left..right)
            if (ans.length > sub.length) ans = sub
            val leftCh = input.elementAt(left)
            if (map.containsKey(leftCh)) {
                map[leftCh] = map[leftCh]!! + 1
                if (map[leftCh]!! > 0) matched--
            }
            left++
        }
        right++

    }


    return if (ans.length < (input + pattern).length) ans else ""
}




