package problems.medium

fun main() {

    print(checkInclusion("abc","aaacb"))

}

fun checkInclusion(pattern: String, input: String): Boolean {

    val freqMap = hashMapOf<Char, Int>()
    var left = 0
    var right = 0
    var matched = 0

    for (str in pattern) {
        if (freqMap.containsKey(str)) freqMap[str] = freqMap[str]!! + 1 else freqMap[str] = 1
    }


    while (right < input.length) {
        val ch = input.elementAt(right)
        if (freqMap.containsKey(ch)) {
            freqMap[ch] = freqMap[ch]!! - 1
            if (freqMap[ch] == 0) matched++
        }


        if (matched == freqMap.size) return true


        if (right >= pattern.lastIndex) {
            val leftValue = input[left]
            if (freqMap.containsKey(leftValue)) {
                if (freqMap[leftValue] == 0) matched--
                freqMap[leftValue] = freqMap[leftValue]!! + 1
            }
            left++

        }
        right++

    }
    return false
}
