package com.vah.kots.study;

import kotlinx.coroutines.*
/**
 *@Description
 *@Author HuangJiang
 **/
class T1 {
}
fun main(args: Array<String>) {
    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        println("World!") // 在延迟后打印输出
    }
    println("Hello,") // 协程已在等待时主线程还在继续
}
