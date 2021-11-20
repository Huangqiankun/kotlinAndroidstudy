package com.hqk.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


//⽗协程的职责
//⼀个⽗协程总是等待所有的⼦协程执⾏结束。
fun main() = runBlocking<Unit> {
    val request = launch {
        repeat(3){ i ->
            launch {
                delay((i + 1) * 200L)
                println("Coroutine $i is done")
            }
        }
        println("request: I'm done and I don't explicitly join my children that are still active")
    }
    //request.join()
    println("Now processing of the request is complete")
}



