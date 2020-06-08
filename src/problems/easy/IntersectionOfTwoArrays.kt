package problems.easy

fun main() {
    val arr1 = intArrayOf(1, 2, 2, 1)
    val arr2 = intArrayOf(2, 2)

    print(intersection(arr1, arr2).joinToString(","))
}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val set = HashSet<Int>(nums1.size)
    val finalSet = HashSet<Int>(nums1.size)

    set.addAll(nums1.asSequence())

    nums1.forEach {
        set.add(it)
    }

    nums2.forEach {
        if(set.contains(it)) finalSet.add(it)
    }

    for (num in nums2) {
        if (set.contains(num)) {
            finalSet.add(num)
        }
    }
    return finalSet.toIntArray()
}