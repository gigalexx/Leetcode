package problems.hard
//340. Longest Substring with At Most K Distinct Characters
fun main() {


    print(findLength("eceba", 2))
}

fun findLength(str: String, K: Int): Int {
    var map = hashMapOf<Char, Int>()


    var max = 0
    var left = 0
    var right = 0

    while (right < str.length) {
        val ch = str[right]

        if (map.containsKey(ch)) map[ch] = map[ch]!! + 1 else map[ch] = 1

        while (map.size > K) {
            max = kotlin.math.max(max, right - left)
            var value = map[str[left]]
            map[str[left]] = value!! - 1
            if (map[str[left]] == 0) {
                map.remove(str[left])
            }
            left++
        }
        right++
    }

    return kotlin.math.max(max,right - left)
}