package com.example.notepad.basis

class OOpsConceptsExm {


        // property (data member)
        private var isOn: Boolean = false

        // member function
        fun turnOn() {
            isOn = true
        }

        // member function
        fun turnOff() {
            isOn = false
        }

        fun displayLightStatus(lamp: String) {
            if (isOn)
                println("$lamp lamp is on.")
            else
                println("$lamp lamp is off.")
        }
    }

    fun main() {

        val l1 = OOpsConceptsExm() // create l1 object of Lamp class
        val l2 = OOpsConceptsExm() // create l2 object of Lamp class

        l1.turnOn()
        l2.turnOff()

        l1.displayLightStatus("l1")
        l2.displayLightStatus("l2")

        val t1 = MathTeacher(25, "Jack")
        t1.teachMaths()

        println()

        val f1 = Footballer(29, "Christiano")
        f1.playFootball()



    }


open class Person(age: Int, name: String) {
    init {
        println("My name is $name.")
        println("My age is $age")
    }
}

class MathTeacher(age: Int, name: String): Person(age, name) {

    fun teachMaths() {
        println("I teach in primary school.")
    }
}

class Footballer(age: Int, name: String): Person(age, name) {
    fun playFootball() {
        println("I play for LA Galaxy.")
    }
}


