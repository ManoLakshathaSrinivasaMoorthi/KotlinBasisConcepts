package com.example.notepad.basis

class InnerClassExm {


    val name1 = "Outer"
    fun show() = "the name: $name1"

    inner class Inner {

        val name2 = "Inner"
        fun show() = "data: $name2 and $name1"
    }

    fun main() {

        println(InnerClassExm().show())
        println(InnerClassExm().Inner().show())
    }
}
