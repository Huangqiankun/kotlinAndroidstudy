package com.hqk.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun log(msg:String) = println("[${Thread.currentThread().name}] $msg")

//⽤⽇志调试
fun main() = runBlocking<Unit> {
    val a = async {
        log("I'm computing a piece of the answer")
        6
    }
    val b = async {
        log("I'm computing another piece of the answer")
        7
    }
    log("The answer is ${a.await() * b.await()}")
}



