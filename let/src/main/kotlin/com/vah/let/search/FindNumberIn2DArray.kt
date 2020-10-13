package com.vah.let.search;

/**
 *@Description
 *@Author HuangJiang
 **/
class FindNumberIn2DArray {
}

fun findNumberIn2DArray1(arr: Array<Array<Int>>, target: Int): Boolean {

    for (ints in arr) {
        for (int in ints) {
            if (int == target) return true
        }
    }
    return false
}

fun findNumberIn2DArray2(arr: Array<Array<Int>>, target: Int): Boolean {



    return false
}
