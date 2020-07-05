package problems.easy

/*
https://leetcode.com/problems/repeated-string-match/solution/
686. Repeated String Match
Easy

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.

TC -> O(N∗(N+M) -> O(N)
SC -> O(M+N) -> O(N)
 */


fun main() {

    repeatedStringMatch("abcd", "cdabcdab")
}

fun repeatedStringMatch(A: String, B: String): Int {
    var counter = 1
    val builder = StringBuilder(A)
    while (builder.length < B.length) {
        builder.append(A)
        counter++
    }
    if (builder.indexOf(B) >= 0) return counter
    return if (builder.append(A).indexOf(B) >= 0) counter + 1 else -1
}