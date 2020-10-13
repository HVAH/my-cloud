package com.vah.let.array;

/**
 *@Description
 *@Author HuangJiang
 * nums = [0,0,1,1,1,2,2,3,3,4]
 **/


fun main() {
    val arr = arrayOf(1,2,2,3,3,3,4,4,4)
    println(remove(arr))
}
// 0,0,1,1,1,4,4
// 0,4,1,1,1,0,4
// 0,4,1,1,1,4,0
fun removeDuplicates2(arr: Array<Int>): Int {
    val size = arr.size
    if (size <2) return size
    val max = arr.last()
    if (arr[0] == max) return 1
    var i = 0
    while (i < arr.size -1) {
        if (arr[i] >= max) {
            break
        } else if (arr[i] == arr[i+1]) {
            for (j in i+1..arr.size-2) {
                if (arr[j] > arr[j+1]){
                    break
                }
                val a = arr[j]
                arr[j]=arr[j+1]
                arr[j+1]=a
            }
            i--
        }
        println(i)
        println(arr.forEach { print(it) })
        i++
    }
    return arr.indexOf(max) + 1
}

fun remove(arr: Array<Int>): Int {
    val size = arr.size
    if (arr == null || size == 1) {
        return size
    }
    var i = 0
    var j = 1
    while (j < size) {
        if (arr[i] == arr[j]) {
            j++
        } else {
            i++
            arr[i] = arr[j]
            j++
        }
        println(i)
        println(j)
        println(arr.forEach { print(it) })
    }
    return i + 1
}