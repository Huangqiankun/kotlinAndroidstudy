package com.hqk.coroutines

import kotlinx.coroutines.*

//等待一个作业
//延迟一段时间来等待另一个协程运行并不是一个好的选择。
//让我们显式（以非阻塞方式）等待所启动的后台 Job 执行结束：
//POSIX线程
//fun main() = runBlocking<Unit> { //开始执行主协程
//    val job:Job = GlobalScope.launch {
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,")
//    job.join() // 等待直到子协程执行结束
//    //....
//}

//简化写法
//结构化并发
//我们可以在执行操作所在的指定作用域内启动协程，
//而不是像通常使用线程（线程总是全局的）那样在 GlobalScope 中启动。

//Cooperation 合作，协作
//Routine 日常，常规的事物

//在我们的示例中，我们使用 runBlocking 协程构建器将 main 函数转换为协程。
//包括 runBlocking 在内的每个协程构建器都将 CoroutineScope 的实例添加到其代码块所在的作用域中。
//我们可以在这个作用域中启动协程而无需显式 join 之，因为外部协程（示例中的 runBlocking）
//直到在其作用域中启动的所有协程都执行完毕后才会结束。
fun main() = runBlocking<Unit> {
    launch {
        delay(1000L)
        println("World!")
    }

    println("Hello,")
}

//像不像串行？