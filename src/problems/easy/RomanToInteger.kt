package problems.easy

import java.util.*

fun main() {
print(convert("IX"))
}

fun convert(input: String): Int {
    val hashMap = mutableMapOf<Char, Int>()
    hashMap.put('I', 1)
    hashMap.put('V', 5)
    hashMap.put('X', 10)
    hashMap.put('L', 50)
    hashMap.put('C', 100)
    hashMap.put('D', 500)
    hashMap.put('M', 1000)


    var result = 0
    var prev = 0


    for (index in input.lastIndex downTo 0) {
        val value = hashMap[input[index]]
        if (value!! < prev) {
            result -= value
        } else {
            result += value!!
        }
        prev = value!!
    }

    return result
}