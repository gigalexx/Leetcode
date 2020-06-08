package problems.easy

import java.util.*


fun main(){
    print(findDisappearedNumbers(intArrayOf(4,3,2,7,8,2,3,1)))
}
fun findDisappearedNumbers(nums: IntArray): List<Int> {

    val listOf = mutableListOf<Int>()
    val max = nums.max()!!
    val min = nums.min()!!

    for(num in min..max){
        if(!nums.contains(num)){
        listOf.add(num)
        }
    }
return listOf

}
