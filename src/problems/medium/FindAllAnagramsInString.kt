package problems.medium

fun main(){
    print(findAnagrams("abc","abbcabc"))
}

fun findAnagrams(pattern: String, input: String): List<Int> {

    val freqMap = hashMapOf<Char, Int>()
    var left = 0
    var right = 0
    var matched = 0

    var anagrams = ArrayList<Int>()

    for (str in pattern) {
        if (freqMap.containsKey(str)) freqMap[str] = freqMap[str]!! + 1 else freqMap[str] = 1
    }

    while (right < input.length) {
        val ch = input.elementAt(right)
        if (freqMap.containsKey(ch)) {
            freqMap[ch] = freqMap[ch]!! - 1
            if (freqMap[ch] == 0) matched++
        }


        if (matched == freqMap.size) anagrams.add(left)


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
    return anagrams
}