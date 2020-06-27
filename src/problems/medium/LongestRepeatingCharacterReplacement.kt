package problems.medium

fun main() {

    print(characterReplacement("aabccbb", 2))
}

fun characterReplacement(s: String, k: Int): Int {
    var maxLength = 0
    var left = 0
    var right = 0
    val map = hashMapOf<Char, Int>()
    var maxRepeatLetterCount = 0

    while (right < s.length) {
        val ch = s.elementAt(right)
        if (map.containsKey(ch)) map[ch] = map[ch]!! + 1 else map[ch] = 1
        maxRepeatLetterCount = kotlin.math.max(maxRepeatLetterCount, map[ch]!!);
        while (right - left + 1 - maxRepeatLetterCount > k) {
            map[s.elementAt(left)] = map[s.elementAt(left)]!! - 1

            if (map[s.elementAt(left)] == 0) map.remove(s.elementAt(left))

            left++
        }
        maxLength = kotlin.math.max(maxLength, right - left + 1);
        right++
    }
    return maxLength
}