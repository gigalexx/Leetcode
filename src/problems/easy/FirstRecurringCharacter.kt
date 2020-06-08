package problems.easy

fun main(){



    val emptyList = emptyList<String>()
    var listOfNotNull = listOfNotNull(2,6,8,9)

    emptyList.plusElement("Vasya")
    listOfNotNull.plusElement(3)
    mutableListOf<String>()
    val mutableListOf = mutableListOf<Int>()
    mutableListOf.add(3)


    val intArrayOf = intArrayOf(2, 3, 5, 3, 4, 2, 7, 9)

    print(getFirstDuplicate(intArrayOf))

}

    fun getFirstDuplicate(intArrayOf: IntArray): Int {

        val hashMap = HashSet<Int>(intArrayOf.size)        // if HashMap use put(), if HashSet use add()

        for (element in intArrayOf){
            if (!hashMap.add(element)) return element

        }
        val emptyList = emptyList<String>()
        listOfNotNull(2)
        
        return -1
    }

