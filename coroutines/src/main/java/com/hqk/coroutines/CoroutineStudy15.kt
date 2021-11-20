package com.hqk.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


//上下⽂中的作业
fun main() = runBlocking<Unit> {
    val job = launch {
        println("My job is ${coroutineContext[Job]}")
        //isActive
    }
    //coroutineContext[Job]?.isActive
    //job.isActive
}



