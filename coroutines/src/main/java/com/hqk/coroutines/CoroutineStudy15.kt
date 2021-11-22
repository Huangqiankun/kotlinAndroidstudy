package com.hqk.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


//上下⽂中的作业
fun main() = runBlocking<Unit> {
    val job = launch {
        println("My job is ${coroutineContext[Job]}")
        //isActive
    }
    println(coroutineContext[Job]?.isActive)
    println(job.isActive)
}

//fun main() = runBlocking {
//    newSingleThreadContext("Ctx1").use { ctx1 ->
//
//        log("newSingleThreadContext  Ctx1 $ctx1")
//        newSingleThreadContext("Ctx2").use { ctx2 ->
//            log("start newSingleThreadContext  Ctx2 $ctx2")
//            runBlocking(ctx1) {
//                log("Started in ctx1")
//                withContext(ctx2) {
//                    log("Working in ctx2")
//                }
//                log("Back to ctx1")
//            }
//            log("end newSingleThreadContext  Ctx2")
//        }
//        log("end newSingleThreadContext  Ctx1")
//    }
//
//}


