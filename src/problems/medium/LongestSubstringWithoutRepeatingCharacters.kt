package problems.medium

fun main() {
    print(longestSubstring("abccde"))
}

fun longestSubstring(s: String): Int {

    val map = hashMapOf<Char, Int>()
    var maxLength = 0
    var left = 0
    var right = 0

    while (right < s.length) {
        val ch = s.elementAt(right)
        if (map.containsKey(ch)) map[ch] = map[ch]!! + 1 else map[ch] = 1

        while (map[ch]!! > 1) {
            maxLength = kotlin.math.max(maxLength, right - left)

            map[s.elementAt(left)] = map[s.elementAt(left)]!! - 1
            if (map[s.elementAt(left)]!! == 0) map.remove(s.elementAt(left))
            left++
        }
        right++

    }

    return kotlin.math.max(maxLength, right - left)
}