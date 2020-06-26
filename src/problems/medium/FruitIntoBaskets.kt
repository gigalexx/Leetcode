package problems.medium

fun main(){

  //  print(findLength(charArrayOf('A', 'B', 'C', 'B', 'B', 'C')))
    print(findLengthInts(intArrayOf(3,3,3,1,2,1,1,2,3,3,4)))
}

fun findLength(array: CharArray): Int{

    val map = hashMapOf<Char, Int>()
    var max = 0
    var left = 0
    var right = 0

    while (right < array.size){
        val ch = array[right]
        if(map.containsKey(ch)) map[ch] = map[ch]!! + 1 else map[ch] = 1

        if(map.size > 2){
            var curMax = 0
            for (key in map.keys){
                if(key != ch) curMax +=map[key]!!
            }
          max = kotlin.math.max(max,curMax)
          val value = map[array[left]]
          map[array[left]] = value!! - 1
          if(map[array[left]] == 0) map.remove(array[left])
          left++
        }
        right++
    }

    return kotlin.math.max(max,map.values.sum())
}

fun findLengthInts(tree: IntArray): Int{

    val map = hashMapOf<Int, Int>()
    var max = 0
    var left = 0
    var right = 0

    while (right < tree.size){
        val num = tree[right]
        if(map.containsKey(num)) map[num] = map[num]!! + 1 else map[num] = 1

        if(map.size > 2){
            var curMax = 0
            for (key in map.keys){
                if(key != num) curMax +=map[key]!!
            }
            max = kotlin.math.max(max,curMax)
            val value = map[tree[left]]
            map[tree[left]] = value!! - 1
            if(map[tree[left]] == 0) map.remove(tree[left])
            left++
        }
        right++
    }

    return kotlin.math.max(max,map.values.sum())
}