package com.hqk.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//⾮受限调度器 vs 受限调度器
fun main() = runBlocking<Unit> {

    //协程可以在⼀个线程上挂起并在其它线程上恢复。
    //不适合更新UI
    launch(Dispatchers.Unconfined){
        println("Unconfined : I'm working in thread ${Thread.currentThread().name}")
        delay(500L)
        // 挂起之后，这里是子线程
        println("Unconfined : After delay in thread ${Thread.currentThread().name}")
    }

    launch {
        println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
        delay(1000)
        println("main runBlocking: After delay in thread ${Thread.currentThread().name}")
    }

}



