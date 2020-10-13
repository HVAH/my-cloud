package com.vah.let.math;

/**
 *@Description 汉诺塔求解  始终将n-1个盘子看成一个盘子
 *@Author HuangJiang
 **/
fun main() {
    hanoi(3, "A", "B", "C")
}

/**
 * n 共n个盘子
 * from 起始位置
 * middle 中间位置
 * to 目标位置
 */
fun hanoi(n: Int, from: String, middle: String, to: String) {
    if (n == 1) {
        println("将第${n}个盘子从${from}移动到${to}")
    } else {
        // 将上面所有盘子移动到中间位置
        hanoi(n - 1, from, to, middle)
        // 移动下面的盘子到目标位置
        println("将第${n}个盘子从${from}移动到${to}")
        // 将中间位置的盘子移到目标位置
        hanoi(n -1, middle, from, to)
    }
}
