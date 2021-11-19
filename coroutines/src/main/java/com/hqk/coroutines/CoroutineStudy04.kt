package com.hqk.coroutines

import kotlinx.coroutines.*

//作用域构建器
//除了由不同的构建器提供协程作用域之外，还可以使用 coroutineScope 构建器声明自己的作用域。
//它会创建一个协程作用域并且在所有已启动子协程执行完毕之前不会结束。

//runBlocking 与 coroutineScope 可能看起来很类似，因为它们都会等待其协程体以及所有子协程结束。
//主要区别在于，runBlocking 方法会阻塞当前线程来等待，而 coroutineScope 只是挂起，会释放底层线程用于其他用途。
//由于存在这点差异，runBlocking 是常规函数，而coroutineScope是挂起函数。

fun main() = runBlocking<Unit> {
    launch {
        delay(200L)
        println("Task from runBlocking")

    }
    // 创建一个协程作用域
    coroutineScope {
        launch {
            delay(500L)
            println("Task from nested launch")
        }
        delay(100L)
        println("Task from coroutine scope")
    }

    println("Coroutine scope is over")
}

