package com.vah.let.array

/**
 * 排序方法集合
 * */



/**
 * 冒泡排序
 */
fun maoPaoSort(array: Array<Int>) {
}

/**
 * 快速排序
 */
fun quickSort(array: Array<Int>, start: Int, end: Int) {
    if (start < end) {
        // 低位索引
        var left = start
        // 高位索引
        var right = end
        // 选取一个基准数
        val standard = array[left]
        while (left < right) {
            // 高位向前移动，直到找到第一个比基准数小的，然后将高位值赋给低位值
            while (left < right && array[right] >= standard) {
                right--
            }
            array[left] = array[right]
            // 低位向后移动，直到找到第一个比基准数大的，然后将低位值赋给高位值
            while (left < right && array[left] <= standard) {
                left++
            }
            array[right] = array[left]
        }
        // 此时 left=right 赋予标准值
        array[left] = standard
        // 处理小的数
        quickSort(array, start, left)
        // 处理大的数
        quickSort(array, left + 1, end)
    }
}

fun quicklySort(arr: Array<Int>, start: Int, end: Int) {
    if (start < end) {
        var l = start
        var r = end
        val s = arr[start]
        while (l < r) {
            while (l < r && arr[r] >= s) {
                r--
            }
            arr[l] = arr[r]
            while (l < r && arr[l] <= s) {
                l++
            }
            arr[r] = arr[l]
        }
        arr[l] = s
        quicklySort(arr, start, l)
        quicklySort(arr, l + 1, end)
    }
}

/**
 * 插入排序
 */
fun insertSort(arr: Array<Int>) {
    for (i in 1 until arr.size) {
        // 当前基准数
        var t = arr[i]
        var c = 0
        for (j in i downTo 0) {
            c = j
            println("插入排序: ${arr.contentToString()}")
            if (j == 0) {
                // 没有比较的了
                break
            }
            if (arr[j - 1] > t) {
                // 将前面的大数赋给当前位置
                arr[j] = arr[j - 1]
            } else {
                break
            }
        }
        // 前面没有比基准数大的了  将基准数赋值给当前位置
        arr[c] = t
        println("插入排序: ${arr.contentToString()}")
    }
}

/**
 * 希尔排序
 */
fun shellSort(arr: Array<Int>) {
    var step = 1
    while (step < arr.size / 3) {
        //寻找合适的步长
        step = step * 3 + 1
    }
    while (step > 0) {
        println("step=$step")
        for (i in step until arr.size) {
            var temp = arr[i]
            var j = i - step
            while (j >= 0) {
                //将以temp为元素起点，以step为步进长度构成的list进行插入运算
                if (arr[j] <= temp) {
                    break
                }
                arr[j + step] = arr[j]
                j -= step
            }
            arr[j + step] = temp
        }
        step /= 3
    }
}

/**
 * 归并排序
 */
fun mergeSort(arr: Array<Int>, low: Int, high: Int) {
    if (low < high) {
        val middle = (high + low) / 2
        // 排左边的
        mergeSort(arr, low, middle)
        // 排右边的
        mergeSort(arr, middle + 1, high)
        // 归并
        merge(arr, low, middle, high)
    }
}

fun merge(arr: Array<Int>, low: Int, middle: Int, high: Int) {
    // 临时数组
    val temp = IntArray(high - low + 1)
    //
    var index = 0
    var i = low
    var j = middle + 1
    while (i <= middle && j <= high) {
        if (arr[i] <= arr[j]) {
            temp[index++] = arr[i++]
        } else {
            temp[index++] = arr[j++]
        }
    }
    while (i <= middle) {
        temp[index++] = arr[i++]
    }
    while (j <= high) {
        temp[index++] = arr[j++]
    }
    // 将临时数组赋值给原数组
    for ((k, e) in temp.withIndex()) {
        arr[low + k] = e
    }
}

fun radixSort(arr: Array<Int>) {
    val max = arr.max()!!
    val bucket = Array(10) { IntArray(arr.size) }
    var n = 1
    // 记录bukect里的元素个数
    val counts = IntArray(10) { 0 }
    for (i in 1..max.toString().length) {
        for (v in arr) {
            val index = v / n % 10
//            println(index)
            bucket[index][counts[index]] = v
            counts[index]++
        }
        n *= 10
        var index = 0
        for ((k, v2) in bucket.withIndex()) {
            val count = counts[k]
            if (count != 0) {
                for (l in 0 until count) {
                    arr[index++] = v2[l]
                }
            }
            counts[k] = 0
        }
    }
}

fun main() {
    val arr = arrayOf(10, 9, 4, 6, 8, 8, 2, 0, 5, 3, -1)
    //quicklySort(arr, 0, arr.size - 1)
//    insertSort(arr)
//    shellSort(arr)
//    println("希尔排序: ${arr.contentToString()}")
    val mergeArr = arrayOf(10, 99, 4, 6, 8, 66, 2, 0, 5, 318)
    //merge(arr2, 0, 3, arr2.size - 1)

    mergeSort(mergeArr, 0, mergeArr.size - 1)
    println("归并排序: ${mergeArr.contentToString()}")

    val radixArr = arrayOf(10, 99, 4, 6, 8, 66, 2, 0, 5, 318)
    radixSort(radixArr)
    println("基数排序：${radixArr.contentToString()}")
}
