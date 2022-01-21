package com.example.notepad.basis

class ExceptionHandlingExm {
}/*
fun main(args: Array<String>){
    val str = getNumber("10")
    println(str)
}
fun getNumber(str: String): Int{
    return try {
        Integer.parseInt(str)
    } catch (e: ArithmeticException) {
        0
    }
}*/
// multiple Try and Catch Block
fun main(args: Array<String>){
    try {
        val a = IntArray(5)
        a[5] = 10 / 0
    } catch (e: ArithmeticException) {
        println("arithmetic exception catch")
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("array index outofbounds exception")
    } catch (e: Exception) {
        println("parent exception class")
    }
    println("code after try catch...")
}


// finally Block
/*
fun main (args: Array<String>){
    try {
        val data = 10 / 5
        println(data)
    } catch (e: NullPointerException) {
        println(e)
    } finally {
        println("finally block always executes")
    }
    println("below codes...")
} */
