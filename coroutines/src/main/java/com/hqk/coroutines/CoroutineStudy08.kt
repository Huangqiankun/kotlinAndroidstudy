package com.hqk.coroutines

import kotlinx.coroutines.*

/**
 *
 * @author ningchuanqi
 * @version V1.0
 */

//在 finally 中释放资源

//fun main() = runBlocking {
//    val job = launch {
//        try {
//            repeat(1000) { i ->
//                println("job:I'm sleeping $i ...")
//                delay(10L)
//                //假如在这里释放资源
//            }
//        } finally {
//            //在这里释放资源
//            // 任何尝试在 finally 块中调⽤挂起函数的⾏为都会抛出 CancellationException
//            // 因为这⾥ 持续运⾏的代码是可以被取消的
////            delay(20L)
//            println("job:I'm running finally")
//        }
//    }
//    delay(130L)
//    println("main:I'm tired of waiting!")
//    job.cancelAndJoin()
//    println("main:Now I can quit.")
//}

//在finally中使用挂起函数
fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job:I'm sleeping $i ...")
                delay(10)
            }
        } finally {
            withContext(NonCancellable){
                println("job:I'm running finally")
                delay(20L)
                println("可以在这释放对应的资源了")
            }
        }
    }
    delay(130L)
    println("main:I'm tired of waiting!")
    job.cancelAndJoin()
    println("main:Now I can quit.")
}

