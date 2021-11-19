package com.hqk.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

//什么是协程？
//本质上，协程是轻量级的线程。
//线程的框架（API）
//为什么不直接用Java的线程？回调地狱，编码风格
fun main(){
//    //后台运行的新的协程
//    GlobalScope.launch {
//        //delay 是一个特殊的 挂起函数 ，它不会造成线程阻塞，但是会 挂起 协程，并且只能在协程中使用。
//        delay(1000)
//        println("World!")
//    }
    thread{
        Thread.sleep(1000)
        println("World!")
    }
    println("Hello,")
    //协程已在等待时主线程还在继续，阻塞主线程2秒钟来保证JVM存活
    Thread.sleep(2000)
}

//作为用户感觉上，阻塞和挂起是一样的

//挂起：一般是主动的，由系统或程序发出，甚至于辅存中去。（不释放CPU，可能释放内存，放在外存）
//阻塞：一般是被动的，在抢占资源中得不到资源，被动的挂起在内存，等待某种资源或信号量（即有了资源）将他唤醒。（释放CPU，不释放内存）


//挂起，是车子把货卸了，但是车还在开，车有可能又在拖其他货物了
//阻塞，是货没卸，车子停了，在等红绿灯，变绿灯了就走