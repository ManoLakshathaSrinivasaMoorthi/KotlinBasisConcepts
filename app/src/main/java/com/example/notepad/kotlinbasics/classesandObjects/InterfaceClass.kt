package com.example.notepad.kotlinbasics.classesandObjects

interface InterfaceClass {


    val test: Int

    fun foo(): String

    fun hello() {
        println("Hello there, pal!")
    }
}

    class InterfaceImp : InterfaceClass {

        override val test: Int = 25
        override fun foo() = "Lol"

    }

    fun main(args: Array<String>) {
        val obj = InterfaceImp()

        println("test = ${obj.test}")
        print("Calling hello(): ")

        obj.hello()

        print("Calling and printing foo(): ")
        println(obj.foo())
    }
interface A {

    fun callMe() {
        println("From interface A")
    }
}

interface B  {
    fun callMe() {
        println("From interface B")
    }
}

class C: A, B {
    override fun callMe() {
        super<A>.callMe()
        super<B>.callMe()
    }
}

fun mains(args: Array<String>) {
    val obj = C()

    obj.callMe()
}
