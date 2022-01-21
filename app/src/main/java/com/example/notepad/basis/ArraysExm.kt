 package com.example.notepad.basis


 fun main() {
    val name = arrayOf("Ajay","Prakesh","Michel","John","Sumit")
    val myArray2 = arrayOf(1,10,4,6,15)
    val myArray3 = arrayOf(5,10,20,12,15)
    val myArray4= arrayOf(1,10,4, "Ajay","Prakesh")
    val myArray5: IntArray = intArrayOf(5,10,20,12,15)
    val nums = arrayOf(1, 2, 3, 4, 5)
    println(nums[0])

     nums[0] = 0
    println(nums.contentToString())

    val nums2 = nums.plus(1)
    println(nums2.contentToString())

    val slice = nums.sliceArray(1..3)
    println(slice.contentToString())

    println(nums.first())
    println(nums.last())
    println(nums.indexOf(5))




    for(element in name){
        println(element)
    }

    println()
    for(element in myArray2){
        println(element)
    }
    println()
    for(element in myArray3){
        println(element)
    }
    println()
    for(element in myArray4){
        println(element)
    }
    println()
    for(element in myArray5){
        println(element)
    }

}