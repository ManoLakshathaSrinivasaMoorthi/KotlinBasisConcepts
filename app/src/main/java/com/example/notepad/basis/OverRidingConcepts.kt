package com.example.notepad.basis

 open class OverRidingConcepts {


        open fun displayAge(age: Int) {
            println("My age is $age.")
        }
    }

    class Girl: OverRidingConcepts() {

        override fun displayAge(age: Int) {         //over ride the method
            println("My fake age is ${age - 5}.")
        }
    }

fun main() {
    val girl = Girl()
    girl.displayAge(31)
}

