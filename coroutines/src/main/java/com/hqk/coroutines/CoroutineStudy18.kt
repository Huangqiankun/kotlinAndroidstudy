package com.hqk.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//命名协程以⽤于调试
fun main() = runBlocking<Unit> {
    log("Started main coroutine")

    val v1 = async(CoroutineName("v1coroutine")){
        delay(500L)
        log("Computing v1")
        252
    }

    val v2 = async(CoroutineName("v2coroutine")){
        delay(1000L)
        log("Computing v2")
        6
    }

    log("The answer for v1 / v2 = ${v1.await() / v2.await()}")
}



