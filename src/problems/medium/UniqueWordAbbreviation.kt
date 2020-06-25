package problems.medium

import java.util.*


class UniqueWordAbbreviation(dictionary: Array<String>) {

    private var abbrDict = mutableMapOf<String, Boolean>()
    private var dict = mutableSetOf<String>()

    init {
        dict = HashSet(dictionary.asList())
        for (s in dict) {
            val abbr = toAbbr(s)
            abbrDict[abbr] = !abbrDict.containsKey(abbr)
        }
    }

    private fun toAbbr(s: String): String {
        val n = s.length
        if (n <= 2) {
            return s
        }
        return s.elementAt(0) + (n - 2).toString() + s.elementAt(n - 1)
    }

    fun isUnique(word: String): Boolean {
        val abbr: String = toAbbr(word)
        val hasAbbr = abbrDict[abbr]
        return hasAbbr == null || hasAbbr && dict.contains(word)
    }

}