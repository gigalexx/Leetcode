package problems.easy
//https://leetcode.com/problems/backspace-string-compare/
/*
844. Backspace String Compare
Easy

Share
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

TC -> O(N)
SC -> O(N)
*/



fun main() {

    print(backspaceCompare("ab#c", "ad#c"))
}

fun backspaceCompare(S: String, T: String): Boolean {

    val builderS = StringBuilder()
    val builderT = StringBuilder()

    var end = S.lastIndex
    var backSpaceCounter = 0
    while (end >= 0) {

        when {
            S[end] == '#' -> backSpaceCounter++
            backSpaceCounter <= 0 -> builderS.append(S[end])
            else -> backSpaceCounter--
        }
        end--
    }
    end = T.lastIndex
    backSpaceCounter = 0

    while (end >= 0) {
        when {
            T[end] == '#' -> backSpaceCounter++
            backSpaceCounter <= 0 -> builderT.append(T[end])
            else -> backSpaceCounter--
        }
        end--
    }
    return builderS.toString() == builderT.toString()
}