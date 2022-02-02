package com.example.notepad.kotlinbasics.classesandObjects

class NestedAndInnerClasses {
    class Outer {

        val a = "Outside Nested class."

        class Nested {
            val b = "Inside Nested class."
            fun callMe() = "Function call from inside Nested class."
        }
    }

    fun main(args: Array<String>) {
        // accessing member of Nested class
        println(Outer.Nested().b)

        // creating object of Nested class
        val nested = Outer.Nested()
        println(nested.callMe())
    }

    /*
    * with the help of inner keyword we can access the properties of both the outer and nested classes
    */
    class Outer1 {
        val foo = "Outside Nested class."

     inner   class Nested1 {
            // Error! cannot access member of outer class.
            fun callMe() = foo
        }
    }

    fun mains(args: Array<String>) {

        val outer = Outer1()
        println(outer.Nested1().callMe())
    }
}