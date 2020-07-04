package problems.medium
//https://leetcode.com/problems/4sum/submissions/
//18. 4Sum
//Medium
//Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//Note:
//
//The solution set must not contain duplicate quadruplets.
//
//Example:
//
//Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//[-1,  0, 0, 1],
//[-2, -1, 1, 2],
//[-2,  0, 0, 2]
//]
fun main(){

    fourSum(intArrayOf(1,0,-1,0,-2,2),0)
}

fun fourSum(arr: IntArray, target: Int): List<List<Int>> {

    val nums = arr.sortedArray()

    val quads = arrayListOf<ArrayList<Int>>()

    for(first in 0..nums.size - 3){
        if (first > 0 && nums[first - 1] == nums[first]) continue // <-- check only previous value ! NOT FUTURE!
       // if(nums[first] == nums[first + 1]) continue   - <-- wrong check

        for (second in first + 1..nums.size - 2){
           if (second > first + 1 && nums[second - 1] == nums[second]) continue //<-- check only previous value ! NOT FUTURE!
           // if(nums[second] == nums[second + 1]) continue   <-- wrong check

            findPair(nums,target,first,second,quads)

        }
    }

    return quads
}

fun findPair(arr: IntArray, targetSum: Int, first: Int, second: Int, quads: ArrayList<ArrayList<Int>>) {

    var left = second + 1
    var right = arr.lastIndex

    while (left < right){

        val curSum = arr[first] + arr[second] + arr[left] + arr[right]

        when {
            curSum == targetSum -> {
                quads.add(arrayListOf(arr[first],arr[second], arr[left],arr[right]))
                left++
                right--
                while (left < right && arr[left -1] == arr[left]) left++
                while (right > left && arr[right + 1] == arr[right]) right--
            }
            curSum < targetSum -> {
                left++
            }
            else -> right--
        }
    }
}
