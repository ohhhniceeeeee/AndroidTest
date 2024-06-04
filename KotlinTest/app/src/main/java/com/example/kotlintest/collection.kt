package com.example.kotlintest

infix fun <T> Collection<T>.has(element: T) = contains(element)