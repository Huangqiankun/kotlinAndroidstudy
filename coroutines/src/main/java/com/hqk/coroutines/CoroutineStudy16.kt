package com.hqk.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


//⼦协程
fun main() = runBlocking<Unit> {
    //当⼀个⽗协程被取消的时候，所有它的⼦ 协程也会被递归的取消。
    val request = launch {
        // 孵化了两个⼦作业, 其中⼀个通过 GlobalScope 启动
        // 当使⽤ GlobalScope 来启动⼀个协程时，则新协程的作业没有⽗作业。
        //因此它与这个启动的作⽤域⽆关 且独⽴运作。
        GlobalScope.launch {
            log("job1: I run in GlobalScope and execute independently!")
            delay(2000)
            log("job1: I am not affected by cancellation of the request")
        }

        launch {
            delay(100)
            log("job2: I am a child of the request coroutine")
            delay(2000)
            log("job2: I will not execute this line if my parent request is cancelled")
        }

    }

    delay(500)
    request.cancel()
    delay(5000)
    log("main: Who has survived request cancellation?")
}



