package com.example.notepad.basis

class OpertorsExm {

    fun relativeExm() {
        val a = 5
        val b = 10
        val max = if (a > b) {
            println("a is greater than b.")
            a
        } else{
            println("b is greater than a.")
            b
        }
        println("max = $max")
    }




    fun unaryExm() {
        var a=10
        var b=5
        val flag = true
        println("+a :"+ +a)
        println("-b :"+ -b)
        println("++a :"+ ++a)
        println("--b :"+ --b)
        println("!flag :"+ !flag)
    }

    fun main() {
        val a=10
        val b=5
        val c= OpertorsExm()
        c.relativeExm()
        val d= OpertorsExm()
        d.unaryExm()
        println(a+b)
        println(a-b)
        println(a*b)
        println(a/b)
        println(a%b)
        println(c)
        println(d)

    }
}