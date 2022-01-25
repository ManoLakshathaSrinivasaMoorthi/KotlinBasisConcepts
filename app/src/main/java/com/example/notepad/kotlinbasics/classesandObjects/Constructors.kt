package com.example.notepad.kotlinbasics.classesandObjects

class Constructors {

    /*
    * Primary constructors
    */
    fun main(args: Array<String>) {

        val person1 = Person("Joe", 25)

        println("First Name = ${person1.firstName}")
        println("Age = ${person1.age}")
    }

    class Person(val firstName: String, var age: Int) {

    }

    /*
    * Primary Constructors and Init blocks
    */
    fun mains(args: Array<String>) {
        val person1 = Person1("joe", 25)
    }

    class Person1(fName: String, personAge: Int) {
        val firstName: String
        var age: Int

        // initializer block
        init {
            firstName = fName.capitalize()
            age = personAge

            println("First Name = $firstName")
            println("Age = $age")
        }
    }

    //same task with different approach
    fun mainss(args: Array<String>) {
        val person1 = Person2("joe", 25)
    }

    class Person2(fName: String, personAge: Int) {
        val firstName = fName.capitalize()
        var age = personAge

        // initializer block
        init {
            println("First Name = $firstName")
            println("Age = $age")
        }
    }
    /*
    * Default value in Primary Constructot
    */
    fun mainsss(args: Array<String>) {

        println("person1 is instantiated")
        val person1 = Person3("joe", 25)

        println("person2 is instantiated")
        val person2 = Person3("Jack")

        println("person3 is instantiated")
        val person3 = Person3()
    }

    class Person3(_firstName: String = "UNKNOWN", _age: Int = 0) {
        val firstName = _firstName.capitalize()
        var age = _age

        // initializer block
        init {
            println("First Name = $firstName")
            println("Age = $age\n")
        }
    }

    /*
    * Secondary Constuctors
    */
    open class Log {
        constructor(data: String) {
            // some code
        }
        constructor(data: String, numberOfData: Int) {
            // some code
        }
    }

    class AuthLog: Log {
        constructor(data: String): super(data) {
            // code
        }
        constructor(data: String, numberOfData: Int): super(data, numberOfData) {
            // code
        }
    }
    /*
    * In Kotlin, you can also call a constructor from another constructor of the same class (like in Java) using this()
    */
    class AuthLogs: Log {
        constructor(data: String): this(data, 10) {
            // code
        }
        constructor(data: String, numberOfData: Int): super(data, numberOfData) {
            // code
        }
    }
    fun mainLogs(args: Array<String>) {

        val p1 = AuthLogss("Bad Password")
    }

    open class Logs {
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

    class AuthLogss: Logs {
        constructor(_data: String): this("From AuthLog -> " + _data, 10) {
        }

        constructor(_data: String, _numberOfData: Int): super(_data, _numberOfData) {
        }
    }
}