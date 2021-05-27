package com.vah.let.array;

/**
 *@Description
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *@Author HuangJiang
 * nums = [0,0,1,1,1,2,2,3,3,4]
 **/


fun main() {
    val arr = arrayOf(1,2,2,3,3,3,4,4,4)
    //println(r3(arr))
    get7(1000)
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
// 1,2,2,2,3,3,3,4,4,4
//
fun r3(arr: Array<Int>): Int {
    var i = 1
    var max = arr.last();
    while ( i < arr.size) {
        println(i)
        if (arr[i] == arr[i+1]) {
            i++

        } else if(arr[i] ==0)
        {
            i++
        }
        println(arr.forEach { print(it) })
        println(i)
    }
    print(arr.toString())
    return arr.indexOf(max)
}

fun get7(num: Int) {
    // 找出每个位数的7 + 找出7的倍数
    var w  = 1
    var t = num
    while (t > 10) {
        t /= 10
        w++
    }
    val result = mutableSetOf<Int>()
    var m = 1
    var r = 7
    while (r < num) {
        println(r)
        result.add(r)
        r = 7*(++m)
    }
    for (i in 1..w) {
        val max = getResult(10, i) - 1
        var r = if (i == 1) 7 else getResult(10, i - 1) + 7
        println(r)
        result.add(r)
        val c = getResult(10, i - 1)
        for(i in 1 until c) {
            println("c=$c")
            result.add(c * 7 + i)
        }
        if ( i > 1) {
            for (j in 1..i) {
                val c = getResult(10, j)
                var count = (max + 1) / c

                for (k in 1 until count) {
                    val f = r + c* k
                    if (k == 6) {
                        val d = f / 10 * 10
                        for (m in 1 until c) {
                            println("d=$d  m=$m")
                            result.add(d + m)
                        }
                    }
                    if (f <= num) {
                        result.add(f)
                        println("j=$j   c=$c   count=$count  f=$f")
                    }
                }
            }
        }
    }

    val sorted = result.distinct().sorted().toMutableList()
    sorted.forEach{print("$it,")}
    println()
    val list = mutableListOf(7,14,17,21,27,28,35,37,42,47,49,56,57,63,67,70,71,72,73,74,75,76,77,78,79,84,87,91,97,98,105,107,112,117,119,126,127,133,137,140,147,154,157,161,167,168,170,171,172,173,174,175,176,177,178,179,182,187,189,196,197,203,207,210,217,224,227,231,237,238,245,247,252,257,259,266,267,270,271,272,273,274,275,276,277,278,279,280,287,294,297,301,307,308,315,317,322,327,329,336,337,343,347,350,357,364,367,370,371,372,373,374,375,376,377,378,379,385,387,392,397,399,406,407,413,417,420,427,434,437,441,447,448,455,457,462,467,469,470,471,472,473,474,475,476,477,478,479,483,487,490,497,504,507,511,517,518,525,527,532,537,539,546,547,553,557,560,567,570,571,572,573,574,575,576,577,578,579,581,587,588,595,597,602,607,609,616,617,623,627,630,637,644,647,651,657,658,665,667,670,671,672,673,674,675,676,677,678,679,686,687,693,697,700,707,714,717,721,727,728,735,737,742,747,749,756,757,763,767,770,771,772,773,774,775,776,777,778,779,784,787,791,797,798,805,807,812,817,819,826,827,833,837,840,847,854,857,861,867,868,870,871,872,873,874,875,876,877,878,879,882,887,889,896,897,903,907,910,917,924,927,931,937,938,945,947,952,957,959,966,967,970,971,972,973,974,975,976,977,978,979,980,987,994,997)
    val s = list.distinct()
    println(s.size)
    println(sorted.size)

    println(sorted.filter { it <500 }.size)

    sorted.removeAll(list)
    sorted.forEach { print("$it==") }
}
// 求幂
fun getResult(number: Int, count: Int): Int {
    if (count > 0) {
        return number * getResult(number, count - 1)
    }
    return 1
}

