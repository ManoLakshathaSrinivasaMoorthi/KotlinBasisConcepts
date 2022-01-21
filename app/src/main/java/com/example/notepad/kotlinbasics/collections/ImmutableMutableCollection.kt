package com.example.notepad.kotlinbasics.collections



/*
* A collection usually contains a number of objects of the same type and
* these objects in the collection are called elements or items.
*
* Types of collections
* Immutable collection
* Mutable collection
*
* Immutable Collections  ---> It means that it supports only read-only functionalities and
* can not be modified its elements.
*
* Methods of Collections:
* List -->listOf() and listOf<T>()
* Set  -->setOf()
* Map  -->mapOf()
*
* Mutable Collections  -->It supports both the read and write functionalities.
* Mutable collections and their corresponding methods are:
* List -->mutableListOf(),arrayListOf() and  ArrayList
* Set -->mutableSetOf(),hashSetOf()
* Map -->mutableMapOf(),hashMapOf() and HashMap
*/
class ImmutableMutableCollection {

    /*
    * List  : It is a ordered collection in which we can access elements or items by using indices
    * -integer numbers that define a position for each element.
    * Elements can be repeated in a list any number of times.
    * we can not perform add or remove operations in the immutable list.
    */
    fun immutableList()
    {
        val immutableList = listOf("Tamilnadu","Andhra Pradesh","karanataka")
        /*
        * compilation error
        * immutableList.add(7)
        */
        for(item in immutableList)
        {
            println(item)
        }
    }

    /*
    * Set  :It is a collection of unordered elements also it does not support duplicate elements
    * It is a collection of unique elements.
    * We cannot perform add or remove operation because it is an Immutable set.*/
    fun immutableSet()
    {
        var immutableSet=setOf(6,9,9,0,0,"Tamil","English")
        /*
        * compilation error
        * immutableSet.add(7)
        */
        for(item in immutableSet)
        {
            println(item)
        }

    }
    /*
    * Map  :Map key are unique and hold only one value for each key,it is a set of key-value pairs.
    * Each key maps to exactly one value.
    * The values can be duplicates but keys should be unique.
    * Maps  are used to store logical connections between two objects, for example a student ID and their name
    * As it is immutable its size is fixed and its methods support read-only access.
    */

    fun immutableMap()
    {
        var immutableMap = mapOf(9 to "Priya",8 to "Ragu",7 to "Hitesh")
        for(key in immutableMap.keys)
        {
            println(immutableMap[key])
        }
    }
  /*
  * List --> Since mutable list supports read and write operation,decalred elements
  * in the list can either be removed or added.
  */
    fun mutableList()
   {
        var mutableList=mutableListOf("Tamil","English","Hindi")
       //we can modify the element
       mutableList[0] ="kanada"
       //add one more element in the list
       mutableList.add("Abhi")
       for(item in mutableList)
       {
           println(item)
       }
    }
    /*
    * Set  -->The mutable set supports both read and write functionality .
    * We can access add or remove elements from the collections easily and it will preserve the
    * order of the elements
    */

    fun mutableSet()
    {
        var mutableSet=mutableSetOf<Int>(6,10)
        mutableSet.add(2)
        mutableSet.add(5)
        for(item in mutableSet)
        {
            println(item)
        }

    }
    /*
    * Map -->It is mutable so it supports functionalities like put,remove,clear
    */
    fun mutableMap()
    {
        var mutableMap=mutableMapOf<Int,String>(1 to "Priya",2 to "Ragu",3 to "Hitesh");
        mutableMap.put(1,"Praveen")
        mutableMap.put(4,"Abhi")

        for(item in mutableMap.values)
        {
            println(item)
        }
    }
}
