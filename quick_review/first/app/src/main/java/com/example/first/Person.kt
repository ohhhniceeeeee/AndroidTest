package com.example.first

open class Person {
    var name = ""
    var age=0
    fun eat(){
        println(name+" is eating. Age is "+age)
    }
}
class Student:Person(){
    var sno = ""
    var grade = 0
}
fun main(){
    val p = Person()
    p.name = "abc"
    p.age = 10
    p.eat()
}