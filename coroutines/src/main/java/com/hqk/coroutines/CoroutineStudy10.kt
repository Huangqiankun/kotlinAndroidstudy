package com.hqk.coroutines

import kotlinx.coroutines.*

var acquired = 0

//伪代码
class Resource {
    init {
//        println("init")
        acquired++
    }

    fun close() {
        acquired--
    }
}

//世界上最难的动作，是器械归位
//不总是打印输出0，取决于计算机性能，一旦超时，释放资源的操作将不会执行

//fun main() {
//    runBlocking {
//        repeat(1000){
//            launch {
//                val resource = withTimeout(60){
//                    delay(30)
//                    Resource()
//                }
//                resource.close()
//            }
//        }
//    }
//    //非0，有内存泄漏
//    //0代表资源都释放了，没有内存泄漏
//    println(acquired) //期待值是0
//}

////释放资源的操作，放入finally当中
fun main() {
    runBlocking {
        repeat(1000) {
            launch {
                var resource: Resource? = null
                try {
                    withTimeout(60) {
                        delay(30)
                        resource = Resource()
                    }
                } finally {
                    resource?.close()
                }
            }
        }

    }
    //0代表资源都释放了，没有内存泄漏
    println(acquired) //期待值是0
}
