package problems.easy

fun main() {
    val arr = intArrayOf(2, 7, 11, 15,0,5,32,84,17,48)  //0,2,5,7,11,15,17,32,48,84
    print(smallestN(arr, 5))

}

fun smallestN(nums: IntArray, target: Int): Int {

    var left = 0
    var right = nums.lastIndex
    val ourIndex = target

    while (left < ourIndex){
        if(nums[left] > nums[right]){
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
        }
        left++
    }
    while (right > ourIndex){
        if(nums[right] < nums[left]){
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
        }
        right--
    }

    return nums[target - 2]
}

fun insertionSort(A: IntArray, size: Int) {
    var i: Int
    var key: Int
    var j: Int
    i = 1
    while (i < size) {
        key = A[i]
        j = i - 1

        /* Move elements of A[0..i-1], that are greater than key, to one
        position ahead of their current position.
        This loop will run at most k times */
        while (j >= 0 && A[j] > key) {
            A[j + 1] = A[j]
            j = j - 1
        }
        A[j + 1] = key
        i++
    }
}