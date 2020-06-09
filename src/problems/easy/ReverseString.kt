package problems.easy

fun main() {
    println(reverseString("yoyo mastery"))
    println(reverseString2("yoyo mastery"))
}

fun reverseString2(str: String): String {
    val builder = StringBuilder()

    for (index in str.lastIndex downTo 0) {
        builder.append(str[index])
    }

    return builder.toString()
}

fun reverseString(str: String): String {

    if (str.length == 1) {
        return str
    }

    return str.last() + reverseString(str.substring(0, str.lastIndex))
}
