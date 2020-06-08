package myDataStructures

import java.util.*
import kotlin.collections.HashMap

class MyHashMap() {

    private val data = arrayOfNulls<HashMap<String, Int>>(16)


    fun set(key: String, value: Int) {
        val address = getHash(key)

        if (data[address] == null) {
            data[address] = hashMapOf(Pair(key, value))
        } else {
            data[address]?.set(key, value)
        }
    }

    fun get(key: String): Int? {
        val address = getHash(key)
        return data[address]!![key]
    }

    fun keys(): MutableList<String> {
        val listOfKeys = mutableListOf<String>()

        for (d in data) {
            if (d != null) {
                listOfKeys.addAll(d.keys)
            }
        }
        return listOfKeys
    }


    private fun getHash(str: String): Int {
        var hash = 0
        for (s in str) {
            hash += s.toInt() % str.length
        }
        return hash
    }


}