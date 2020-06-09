package Algorithms

fun main() {

    println(getFactorialIteratively(30))
    println(getFactorialRecursively(30))


}

fun getFactorialRecursively(number: Int): Int {
    if (number == 1) {
        return number
    }

    return getFactorialRecursively(number - 1) * number
}

fun getFactorialIteratively(number: Int): Int {
    var sum = 1
    for (num in number downTo 1) {
        sum *= num
    }
    return sum
}