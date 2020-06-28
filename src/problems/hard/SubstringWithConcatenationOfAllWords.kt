package problems.hard

fun main() {
    print(findWordConcatenation("barfoothefoobarman", arrayOf("foo", "bar")))
}

fun findWordConcatenation(input: String, words: Array<String>): List<Int>? {
    val listOfIndices = arrayListOf<Int>()

    val wordsCount = words.size
    val wordLen = words[0].length
    val freqMap = hashMapOf<String, Int>()

    for (str in words) {
        if (freqMap.containsKey(str)) freqMap[str] = freqMap[str]!! + 1 else freqMap[str] = 1
    }

    for (right in 0..input.length - wordLen * wordsCount) {
        val seen = hashMapOf<String, Int>()

        for (left in 0..words.lastIndex) {
            val nextWordIndex = right + left * wordLen
            val nextWord = input.substring(nextWordIndex, nextWordIndex + wordLen)

            if (!freqMap.containsKey(nextWord)) break

            if (seen.containsKey(nextWord)) seen[nextWord] = seen[nextWord]!! + 1 else seen[nextWord] = 1

            if (seen[nextWord]!! > freqMap[nextWord]!!) break

            if (left == words.lastIndex) listOfIndices.add(right)

        }
    }
    return listOfIndices
}