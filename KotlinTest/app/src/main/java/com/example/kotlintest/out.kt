package com.example.kotlintest

open class Person(val name: String, age: Int)
class Student(name: String, age: Int) : com.example.kotlintest.Person(name, age)
class Teacher(name: String, age: Int) : com.example.kotlintest.Person(name, age)
class SimpleData<out T>(val data: T?) {
    fun get(): T? {
        return data
    }
}

fun handleMyData(data: SimpleData<Person>) {
    val personData = data.get()
}

fun main() {
    val student = Student("name1", 11)
    val data = SimpleData<Student>(student)
    handleMyData(data)
    val studentData = data.get()
}