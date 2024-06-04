package com.example.kotlintest

import java.lang.RuntimeException

fun main() {
    val a = 5.1
    val b = 7.5
    val c = 3.6
    val maxNum = max(a, b, c)
    println(maxNum)
}

//fun max(vararg nums: Int): Int {
//    if (nums.isEmpty()) {
//        throw RuntimeException("Params can not be empty.")
//    }
//    var maxNum = nums[0]
//    for (num in nums) {
//        maxNum = kotlin.math.max(maxNum, num)
//    }
//    return maxNum
//}

fun <T : Comparable<T>> max(vararg nums: T): T {
    if (nums.isEmpty()) throw RuntimeException("Params can no be empty.")
    var maxNum = nums[0]
    for (num in nums) {
        if (num > maxNum) {
            maxNum = num
        }
    }
    return maxNum
}