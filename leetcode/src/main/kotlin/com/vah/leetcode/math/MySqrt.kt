package com.vah.leetcode.math;

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow

/**
 *@Description 平方根
 *@Author HuangJiang
 **/
fun sqrt(a: Int): Int {
    if (a <= 0) return 0
    var x = 1.0
    var c: Double
    do {
        x = (x + a / x) / 2.0
        c = x * x - a
        c = if (c < 0) -c else c
    } while (c > 0.1)
    return x.toInt()
}

fun main() {
    println(sqrt(9))
}
