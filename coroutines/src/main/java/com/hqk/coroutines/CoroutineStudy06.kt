package com.hqk.coroutines

import kotlinx.coroutines.*
import kotlin.concurrent.thread

//取消协程的执⾏

//我们之前 没有在控制台上看到堆栈跟踪信息的打印。
//这是因为在被取消的协程中 CancellationException 被认为 是协程执⾏结束的正常原因。
fun main() = runBlocking<Unit> {
    val job = launch {
        repeat(1000){ i ->
            println("job:I'm sleeping $i")
            delay(10L)
        }
    }
    delay(130L)
    println("main: I'm tired of waiting!")
//    job.cancel()
//    job.join()
    job.cancelAndJoin()
    println("main:Now I can quit!")
}