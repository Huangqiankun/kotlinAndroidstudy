package com.hqk.coroutines

import kotlinx.coroutines.*

/**
 *
 * @author ningchuanqi
 * @version V1.0
 */
//超时
//在实践中绝⼤多数取消⼀个协程的理由是它有可能超时。
//withTimeout 抛出了 TimeoutCancellationException ，它是 CancellationException 的⼦类。
//我们之前 没有在控制台上看到堆栈跟踪信息的打印。
//这是因为在被取消的协程中 CancellationException 被认为 是协程执⾏结束的正常原因。
fun main() = runBlocking {
//    withTimeout(1330L){
//        repeat(1000){ i ->
//            println("I'm sleeping $i")
//            delay(500L)
//        }
//    }

    //withTimeoutOrNull 通过返回 null 来进⾏超时操作，从⽽替代抛出⼀个异常：
    val result = withTimeoutOrNull(1330L){
        repeat(1000){ i ->
            println("I'm sleeping $i")
            delay(500L)
        }
        "OK"
    }
    println(result ?: "Done")
}