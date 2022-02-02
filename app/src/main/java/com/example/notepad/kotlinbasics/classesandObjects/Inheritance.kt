package com.example.notepad.kotlinbasics.classesandObjects

class Inheritance {
    fun main() {

        val p1 = AuthLog("Bad Password")
    }

    open class Log {
        var data: String = ""
        var numberOfData = 0
        constructor(_data: String) {

        }
        constructor(_data: String, _numberOfData: Int) {
            data = _data
            numberOfData = _numberOfData
            println("$data: $numberOfData times")
        }
    }

    class AuthLog: Log {
        constructor(_data: String): this("From AuthLog -> + $_data", 10) {
        }

        constructor(_data: String, _numberOfData: Int): super(_data, _numberOfData) {
        }
    }

    open class Person(age: Int, name: String) {
        // some code
    }

    class Footballer(age: Int, name: String, club: String): Person(age, name) {
        init {
            println("Football player $name of age $age and plays for $club.")
        }

        fun playFootball() {
            println("I am playing football.")
        }
    }

    fun mains() {
        val f1 = Footballer(29, "Cristiano", "LA Galaxy")
        f1.playFootball()
    }


    /*
    * Overriding methods
    */
    // Empty primary constructor
    open class Persons() {
        open fun displayAge(age: Int) {
            println("My age is $age.")
        }
    }

    class Girl: Persons() {

        override fun displayAge(age: Int) {
            println("My fake age is ${age - 5}.")
        }
    }

    fun main(args: Array<String>) {
        val girl = Girl()
        girl.displayAge(31)
    }
    /*
    * Calling Members of Base Class from Derived Class
    */

    open class Personss() {
        open fun displayAge(age: Int) {
            println("My actual age is $age.")
        }
    }

    class Girls: Personss() {

        override fun displayAge(age: Int) {

            // calling function of base class
            super.displayAge(age)

            println("My fake age is ${age - 5}.")
        }
    }

    fun mainGirls(args: Array<String>) {
        val girl = Girl()
        girl.displayAge(31)
    }
}