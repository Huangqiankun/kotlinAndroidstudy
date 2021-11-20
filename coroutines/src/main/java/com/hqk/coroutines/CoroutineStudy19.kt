package com.hqk.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//组合上下⽂中的元素
fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default + CoroutineName("test")) {
        println("I'm working in thread ${Thread.currentThread().name}")
    }
}



