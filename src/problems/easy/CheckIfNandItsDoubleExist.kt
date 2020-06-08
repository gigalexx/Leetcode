package problems.easy

fun main(){

    val arr = intArrayOf(3,1,7,11)
    print(checkIfExist2(arr))
}

fun checkIfExist(arr: IntArray): Boolean {
    val set = HashSet<Int>(arr.size)
    var zeroCounter = 0
    for (num in arr){
        if (num == 0) zeroCounter++ else set.add(num)
    }
    if (zeroCounter > 1) return true
    for (num in arr){
        if (set.contains(num*2)) return true
    }
    return false
}

fun checkIfExist2(arr: IntArray): Boolean {
    val set = HashSet<Int>(arr.size)
    for (num in arr){
        when {
            num == 0 && set.contains(num) -> return true
            set.contains(num * 2) || set.contains(num / 2) && num % 2 == 0 -> return true
            else -> set.add(num)
        }
    }
    return false
}