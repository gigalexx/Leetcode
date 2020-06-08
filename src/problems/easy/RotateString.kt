package problems.easy

fun main() {

    print(compare("abcde","cdeab"))

}

fun compare(str1: String, str2: String): Boolean {

    var pointer1 = 0
    var pointer2 = str2.indexOf(str1[pointer1])
    

    if (pointer2 == -1) return false

    for (index in 1..str1.lastIndex) {
        pointer2++
        if (pointer2 > str2.lastIndex) pointer2 = 0

        if (str1[index] != str2[pointer2]) return false

    }
    return true
}