package com.hqk.coroutines

import kotlinx.coroutines.*

//fun main(){
//    GlobalScope.launch {
//        delay(1000)
//        println("World!")
//    }
//    println("Hello,")
//    //这个表达式阻塞了主线程，我们延迟 2 秒来保证 JVM 的存活
//    runBlocking {
//        delay(2000L)
//    }
//    //结果是相似的，但是这些代码只使用了非阻塞的函数 delay。
//    //调用了 runBlocking 的主线程会一直阻塞直到 runBlocking 内部的协程执行完毕。
//}

//这个示例可以使用更合乎惯用法的方式重写，使用 runBlocking 来包装 main 函数的执行：
//把主线程包装了一个Kotlin的携程
fun main() = runBlocking<Unit> { //开始执行主协程
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    delay(2000L)
}
