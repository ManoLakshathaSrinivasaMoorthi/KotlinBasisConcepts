package com.example.notepad.basis


class CoRoutineExample {
    suspend fun helloSuspend(){
        println("Hello Suspending Functions")
    }


//lambda expression




    data class User(val name: String, val email: String)


}


fun main() {
    println("Start")
    Thread.currentThread().name
    Thread.sleep(1000)
    Thread.currentThread().name
    println("Inside launch")

    println("Finished")
    //helloSuspend() //this won't compile

    val u = CoRoutineExample.User("Peter Novak", "pnovak47@gmail.com")
    println(u)

    println(u.name)
    println(u.email)

    val (name, email) = u;
    println("$name $email")

    val u2 = CoRoutineExample.User("Peter Novak", "pnovak47@gmail.com")

    println(u == u2)
    println(u === u2)

}