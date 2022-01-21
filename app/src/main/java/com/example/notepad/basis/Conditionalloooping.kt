package com.example.notepad.basis

import android.util.Log

class Conditionalloooping {

    // IF-Else function block
    fun ifConditions() {
        val number1 = 80
        val number2 = 90
        if (number1 > number2)
            Log.d("IfStatements", "the $number1 Number is bigger")
        else {
            Log.d("IfStatements", "the $number2 Number is bigger")
        }

    }


    // forLoop functions

    fun forLoops() {
        val a = 10
        for (i in 1..20) {
            Log.d("forLoop", "the $a Number is in range of 1-20")
        }
        Log.d("forloop", "the $a Number is not in range of 1-20")
    }

    // WhileLoop Function

    fun whileLoops() {
        var a = 8
        while (a <= 10) {
            Log.d("forloop", "the value is :\t $a ")
            a++
        }

    }

    // Do-While loops

    fun dowhileLoops() {
        var a = 20
        do {
            Log.d("forloop", "the value is :\t $a ")
            a++
        } while (a <= 30)

    }


    // When it replace the Switch Function
    fun whenConditions(){
        when(val a = 30){
            10-> Log.d("WhenCondition", "the value is :\t $a ")
            20-> Log.d("WhenCondition", "the value is :\t $a ")
            30-> Log.d("WhenCondition", "the value is :\t $a ")
            else-> Log.d("WhenCondition", "Enter Correct Number")
        }

    }


}


class Interj{
    fun  omfg(){

    }
}

fun main(){

    //Shaowing Integer Results
    val integerValue= DatatypeExample()
    integerValue.a=10
    integerValue.b=20
    integerValue.result=integerValue.a+integerValue.b
    Log.d("IntegerData","the result is ${integerValue.result}")

    // Showing the Float value Results
    val floatValues= DatatypeExample()
    floatValues.c=30.0F
    floatValues.d=40.0F
    val results=floatValues.c+floatValues.d
    Log.d("FloatData","the result is $results")

    //Showing String Values
    val username= DatatypeExample()
    username.name="Ganesh"
    Log.d("StringData","the UserName   is $username")

    // Showing IFCondition results

    val ifstatement= Conditionalloooping()
    ifstatement.ifConditions()

    // Showing the Looping Results
    val  loopingvalues= Conditionalloooping()
    loopingvalues.forLoops()

    // Showing the While Loop Results

    val whileloops= Conditionalloooping()
    whileloops.whileLoops()

    // Showing the DO-While Loop Results

    val dowhileloops= Conditionalloooping()
    dowhileloops.dowhileLoops()

    // Showing the WhenConditional Results

    val whenfunctions= Conditionalloooping()
    whenfunctions.whenConditions()
 val wert= Interj()
wert.omfg()
}