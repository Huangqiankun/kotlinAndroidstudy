package com.hqk.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//协程总是运⾏在⼀些以 CoroutineContext 类型为代表的上下⽂中
//协程上下⽂是各种不同元素的集合。其中主元素是协程中的 Job
fun main() = runBlocking<Unit> {

    //所有的协程构建器诸如 launch 和 async 接收⼀个可选的 CoroutineContext 参数，
    //它可以被⽤来显式的为⼀ 个新协程或其它上下⽂元素指定⼀个调度器。

    //当调⽤ launch { …… } 时不传参数，它从启动了它的 CoroutineScope 中承袭了上下⽂（以及调度器）。
    //在这 个案例中，它从 main 线程中的 runBlocking 主协程承袭了上下⽂。
    launch {
        delay(1000)
        println("main runBlocking : I'm working in thread ${Thread.currentThread().name}")
    }

    // 不受限的——将⼯作在主线程中
    // ⾮受限的调度器⾮常适⽤于执⾏不消耗 CPU 时间的任务，以及不更新局限于特定线程的任何共享数据（如UI）的协程。
    launch(Dispatchers.Unconfined) {
        println("Unconfined : I'm working in thread ${Thread.currentThread().name}")
    }

    // 将会获取默认调度器
    // 默认调度器使⽤共享 的后台线程池。
    launch(Dispatchers.Default) {
        println("Default : I'm working in thread ${Thread.currentThread().name}")
    }

    // 将使它获得⼀个新的线程
    // ⼀个专⽤的线程是⼀种⾮常昂贵的资源。
    launch(newSingleThreadContext("MyOwnThread")) {
        println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
    }
}



