package com.hqk.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


//fun main() = runBlocking {
//    val one = doSomethingUsefulOne()
//    val two = doSomethingUsefulTwo()
//    println("The answer is ${one + two}")
//}


////默认顺序调⽤
//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val one = doSomethingUsefulOne()
//        val two = doSomethingUsefulTwo()
//        println("The answer is ${one + two}")
//    }
//    println("Completed in $time ms")
//}

////使⽤ async 并发
//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val one = async { doSomethingUsefulOne() }
//        val two = async { doSomethingUsefulTwo() }
//        println("The answer is ${one.await() + two.await()}")
//    }
//    //这⾥快了两倍，因为两个协程并发执⾏。请注意，使⽤协程进⾏并发总是显式的。
//    println("Completed in $time ms")
//}

////惰性启动的 async
////在计算⼀个值涉及挂起函数时，这个 async(start = CoroutineStart.LAZY)
////的⽤例⽤于替代标准库中的 lazy 函数。
//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
//        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
//        two.start()
//        one.start()
//        println("The answer is ${one.await() + two.await()}")
//    }
//    println("Completed in $time ms")
//}


//async⻛格的函数
/*fun main(){
    val time = measureTimeMillis {
        val one = doSomethingUsefulOneAsync()
        val two = doSomethingUsefulTwoAsync()

        runBlocking {
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Completed in $time ms")
}*/

/*fun main() = runBlocking {
    val time = measureTimeMillis {
        println("The answer is ${concurrentSum()}")
    }
    println("Completed in $time ms")
}*/

//如果其中⼀个⼦协程（即 two ）失败，第⼀个 async 以及等待中的⽗协程都会被取消
fun main() = runBlocking<Unit>{
    try {
        failedConcurrentSum()
    }catch (e:ArithmeticException){
        println("Computation failed with ArithmeticException")
    }
}

//使⽤ async 的结构化并发
suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }
    one.await() + two.await()
}


suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async<Int> {
        try{
            delay(Long.MAX_VALUE)
            42
        }finally {
            println("First child was cancelled")
        }
    }
    val two = async<Int> {
        println("Second child throw an Exception.")
        throw ArithmeticException()
    }
    one.await() + two.await()
}


fun doSomethingUsefulOneAsync() = GlobalScope.async {
    doSomethingUsefulOne()
}

fun doSomethingUsefulTwoAsync() = GlobalScope.async {
    doSomethingUsefulTwo()
}


suspend fun doSomethingUsefulOne(): Int {
    println("doSomethingUsefulOne")
    //所有kotlinx.coroutines中的挂起函数都是可被取消的。
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    println("doSomethingUsefulTwo")
    delay(1000L)
    return 29
}



