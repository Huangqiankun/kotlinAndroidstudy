package com.hqk.coroutines

import kotlinx.coroutines.*
import kotlin.concurrent.thread

//协程的取消是协作的
//如果协程正在执⾏计算任务，那么它是不能被取消的

//fun main() = runBlocking<Unit> {
//    val startTime = System.currentTimeMillis()
//    val job = launch {
//        var nextPrintTime = startTime
//        var i = 0
////        delay(200L)
//        //这里没有挂起函数
//        while (i < 50) {  // ⼀个执⾏计算的循环，只是为了占⽤ CPU
//            if (System.currentTimeMillis() >= nextPrintTime) {
//                println("job:I'm sleeping ${i++} ...")
//                nextPrintTime += 10L
////                delay(1L)
//            }
//        }
//    }
//    delay(130L)
//    println("main:I'm tired of waiting!")
//    job.cancelAndJoin()
//    println("main:Now I can quit.")
//}

//使计算代码可取消
//显式的检查取消状态
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        //isActive 是⼀个可以被使⽤在 CoroutineScope 中的扩展属性
        while(i < 50 && isActive){
            if(System.currentTimeMillis() >= nextPrintTime){
                println("job:I'm sleeping ${i++} ...")
                nextPrintTime += 10L
            }
        }
    }
    delay(130L)
    println("main:I'm tired of waiting!")
    job.cancelAndJoin()
    println("main:Now I can quit.")
}
