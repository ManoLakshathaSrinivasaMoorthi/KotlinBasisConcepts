package com.example.notepad.kotlinbasics.classesandObjects

data class Person(val name: String, var age: Int)
fun main(args: Array<String>) {
    val jack = Person("jack", 29)
    println("name = ${jack.name}")
    println("age = ${jack.age}")
}
data class User(val name: String, val age: Int)

fun mainUser(args: Array<String>) {
    val jack = User("jack", 29)
    println("name = ${jack.name}")
    println("age = ${jack.age}")
}

//cpying
data class Users(val name: String, val age: Int)

fun mainUsers(args: Array<String>) {
    val u1 = Users("John", 29)

    // using copy function to create an object
    val u2 = u1.copy(name = "Randy")

    println("u1: name = ${u1.name}, name = ${u1.age}")
    println("u2: name = ${u2.name}, name = ${u2.age}")
}
//toString
data class Userss(val name: String, val age: Int)

fun mainUserss(args: Array<String>) {
    val u1 = Userss("John", 29)
    println(u1.toString())
}

//hashCode(),toString()
data class UserData(val name: String, val age: Int)

fun mainUserData(args: Array<String>) {
    val u1 = UserData("John", 29)
    val u2 = u1.copy()
    val u3 = u1.copy(name = "Amanda")

    println("u1 hashcode = ${u1.hashCode()}")
    println("u2 hashcode = ${u2.hashCode()}")
    println("u3 hashcode = ${u3.hashCode()}")

    if (u1.equals(u2) == true)
        println("u1 is equal to u2.")
    else
        println("u1 is not equal to u2.")

    if (u1.equals(u3) == true)
        println("u1 is equal to u3.")
    else
        println("u1 is not equal to u3.")
}

//using components
data class Userdatas(val name: String, val age: Int, val gender: String)

fun mainUserDatas(args: Array<String>) {
    val u1 = Userdatas("John", 29, "Male")

    println(u1.component1())     // John
    println(u1.component2())     // 29
    println(u1.component3())     // "Male"
}
