package com.hqk.coroutines

import kotlinx.coroutines.*
import kotlin.concurrent.thread

//提取函数重构
//在协程内部可以像普通函数⼀样使⽤挂 起函数，
//不过其额外特性是，同样可以使⽤其他挂起函数（如本例中的 delay ）来挂起协程的执⾏。

//fun main() = runBlocking<Unit> {
//    launch { doKotlin() }
//    println("Hello,")
//}


//suspend fun doKotlin(){
//    delay(1000L)
//    println("Kotlin!")
//}

//
//fun main(){
//    doKotlin()
//}

////协程很轻量
////它启动了1000个协程，并且在 5 秒钟后，每个协程都输出一个点
////启动了10万个协程，不代表启动了10万个线程
//fun main() = runBlocking<Unit> {
//    repeat(100000){
//        launch {
//            delay(5000)
//            print(".")
//        }
//    }
//}




fun main() = runBlocking<Unit> {
    launch {
        repeat(1000){ i ->
            println("I'm sleeping $i")
            delay(10L)
        }
    }
    delay(130L)
    println("over ")
}