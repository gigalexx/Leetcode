package algorithms
private const val INDEX = 100
fun main() {

    var time = System.currentTimeMillis()

    println(getFibonacciIteratively(INDEX))
    println("Execution time for iterative: ${System.currentTimeMillis() - time}")


    time = System.currentTimeMillis()
    println(getFibonacciRecursivelyDP(INDEX))
    println("Execution time for recursive DP: ${System.currentTimeMillis() - time}")

    time = System.currentTimeMillis()
    println(getFibonacciDownToUp(INDEX))
    println("Execution time for top to down: ${System.currentTimeMillis() - time}")

    time = System.currentTimeMillis()
    //  println(getFibonacciRecursively(INDEX))
    println("Execution time for recursive: ${System.currentTimeMillis() - time}")


}


fun getFibonacciRecursively(n: Int): Int {

    if (n < 2) return n

    return getFibonacciRecursively(n - 1) + getFibonacciRecursively(n - 2)
}

fun getFibonacciDownToUp(n: Int): Int {

    val intArrayOf = arrayListOf<Int>(0, 1)

    for (index in 2..n) {
        intArrayOf.add(intArrayOf[index - 2] + intArrayOf[index - 1])
    }
    return intArrayOf.last()
}

fun getFibonacciRecursivelyDP(n: Int): Int {
    val cache = hashMapOf<Int, Int>()

    fun cal(n: Int): Int {
        if (n < 2) return n
        return when {
            cache.containsKey(n) -> cache[n]!!
            else -> {
                cache[n] = cal(n - 1) + cal(n - 2)
                cache[n]!!
            }
        }
    }
    return cal(n)
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