package problems.medium

fun main(){

    print(longestOnes(intArrayOf(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1),3))
}

fun longestOnes(A: IntArray, K: Int): Int {
    var maxLength = 0
    var left = 0
    var right = 0
    var zeroCounter = K

    while (right < A.size){
      if (A[right] == 0) zeroCounter--

      while (zeroCounter < 0){
          maxLength = kotlin.math.max(maxLength,right - left)
          if (A[left] == 0) zeroCounter++
          left++
      }
       right++

    }


return kotlin.math.max(maxLength,right - left)
}