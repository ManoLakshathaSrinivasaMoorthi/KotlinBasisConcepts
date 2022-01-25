package com.example.notepad.kotlinbasics.classesandObjects

class ClassesAndObjects {
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
        if (isOn == true)
            println("$lamp lamp is on.")
        else
            println("$lamp lamp is off.")
    }
}

fun main(args: Array<String>) {

    val l1 = ClassesAndObjects() // create l1 object of Lamp class
    val l2 = ClassesAndObjects() // create l2 object of Lamp class

    l1.turnOn()
    l2.turnOff()

    l1.displayLightStatus("l1")
    l2.displayLightStatus("l2")
}