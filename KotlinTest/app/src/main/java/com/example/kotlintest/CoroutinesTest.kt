package com.example.kotlintest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

//fun main() {
////    GlobalScope.launch {
////        println("Codes run in coroutine scope")
////    }
////    Thread.sleep(1000)
//
//
////    runBlocking {
////        println("Codes run in coroutine scope")
////        delay(1500)
////        println("Codes run in coroutine scope finished")
////    }
//    val start = System.currentTimeMillis()
//    runBlocking {
//        repeat(100000) {
//            launch {
//                println(".")
//            }
//        }
//    }
//    val end = System.currentTimeMillis()
//    println(end - start)
//}
fun main() {
//    runBlocking{
//        launch{
//            println("launch1")
//            delay(1000)
//            println("launch1 finished")
//        }
//        launch{
//            println("launch2")
//            delay(1000)
//            println("launch2 finished")
//        }
//    }

//    runBlocking {
//        val result = async {
//            1 + 1
//        }.await()
//        println(result)
//    }
    runBlocking {
        val result = withContext(Dispatchers.Default) {
            5 + 5
        }
        println(result)
    }
}

suspend fun printDot() = coroutineScope {
    launch {
        println(".")
        delay(1000)
    }
}