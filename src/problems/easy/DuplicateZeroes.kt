class Solution {
    fun duplicateZeroes(nums: IntArray){
        var skip = false
        for(index in nums.indices){
            if(skip){
                skip = false
                continue
            }
            if(nums[index] == 0) {
                shiftArray(nums, index)
                skip = true
            }
        }
    }
    fun shiftArray(nums: IntArray, startIndex: Int) {
        if(startIndex > nums.size - 2) return
        var nextItemIndex = startIndex + 1
        var oldValue = nums[startIndex]
        while(nextItemIndex < nums.size) {
            val prev = nums[nextItemIndex]
            nums[nextItemIndex] = oldValue
            oldValue = prev
            nextItemIndex++
        }
    }
}