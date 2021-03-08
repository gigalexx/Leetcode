package algorithms

fun main() {
    val input = "Ab9raCad341AdBraA3lak2Az44am"

    println(removeDuplicates(input))

    val num: (Int, Int) -> Int = { a: Int, b: Int -> a + b }

    println(num(4, 93))


}

fun removeDuplicates(input: String): String {

    val set = HashSet<Char>()
    val stringBuilder = StringBuilder()

    for (ch in input) {

        if (ch.isLetter() && !set.contains(ch.toUpperCase())) {
            stringBuilder.append(ch)
            set.add(ch.toUpperCase())
        }
    }


    return stringBuilder.toString()
}

