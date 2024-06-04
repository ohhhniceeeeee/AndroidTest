package com.example.kotlintest

fun main() {
//    if ("aaa bbb" beginsWith "aaa") {
//        println(true)
//    }
    val list = listOf("apple", "banana", "orange", "pear", "grape")
    if (list has "banana") {
        println("has banana")
    }
    val map = mapOf("a" to "b")
}