package Algorithms

fun main() {
    var time = System.currentTimeMillis()

    println(getFibonacciIteratively(45))
    println("Execution time for iterative: ${System.currentTimeMillis() - time}")


    time = System.currentTimeMillis()
    println(getFibonacciRecursively(45))
    println("Execution time for recursive: ${System.currentTimeMillis() - time}")
}


fun getFibonacciRecursively(n: Int): Int {

    if (n < 2) return n

    return getFibonacciRecursively(n - 1) + getFibonacciRecursively(n - 2)
}

fun getFibonacciIteratively(index: Int): Int {

    var prev = 0
    var curr = 1
    for (num in 2..index) {
        curr += prev
        prev = curr - prev
    }
    return curr
}