package com.example.notepad.basis

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class CollectionsExm {

        /**
         * ArrayList class can contain duplicate elements.
         * ArrayList class maintains insertion order.
         * ArrayList class is non synchronized.
          * ArrayList allows random access because array works at the index basis.
         *
         */
        fun ArraylistExm() {
            val list = ArrayList<String>() //Creating arrayli st
            list.add("Mango") //Adding object in arraylist
            list.add("Apple")
            list.add("Banana")
            list.add("Grapes")
            list.add("Banana")
            list.add("Banana")
            list.sort()
            //Printing the arraylist object
            Log.d("ArrayList", list.toString())
        }


        /**
         * LinkedList class can contain duplicate elements.
         * LinkedList class maintains insertion order.
         * LinkedList class is non synchronized.
         *
         */
        fun LinkedListExm() {
            val al = LinkedList<String>()
            al.add("Ravi")
            al.add("Vijay")
            al.add("Ravi")
            al.add("Ajay")
            for (s in al) {
                Log.d("LinkedList", s)
            }
        }


        /**
         * HashSet stores the elements by using a mechanism called hashing.
         * HashSet contains unique elements only.
         * HashSet allows null value.
         * HashSet class is non synchronized.
         */
        fun HashSetExm() {
            val set = HashSet<String>()
            set.add("Ravi")
            set.add("Ravi")
            set.add("Vijay")
            set.add("Arun")
            set.add("Sumit")
            Log.d("HashSet", "An initial list of elements: $set")
            //Removing specific element from HashSet
            set.remove("Ravi")
            Log.d("", "After invoking remove(object) method: $set")
            val set1 = HashSet<String>()
            set1.add("Ajay")
            set1.add("Gaurav")
            set.addAll(set1)
            Log.d("", "Updated List: $set")
            //Removing all the new elements from HashSet
            set.removeAll(set1)
            Log.d("", "After invoking removeAll() method: $set")
            //Removing elements on the basis of specified condition
            set.clear()
            Log.d("", "After invoking clear() method: $set")
        }


        /**
         * TreeSet class contains unique elements only like HashSet.
         * TreeSet class doesn't allow null element.
         * TreeSet class is non synchronized.
         * TreeSet class maintains ascending order.
         */
        fun TreeSetExm() {
            //Creating and adding elements
            val al = TreeSet<String>()
            al.add("Ravi")
            al.add("Vijay")
            al.add("Ravi")
            al.add("Ajay")
            //Traversing elements
            for (s in al) {
                Log.d("TreeSet", "" + s)
            }
        }


        /**
         * HashMap contains values based on the key.
         * HashMap contains only unique keys.
         * HashMap may have one null key and multiple null values.
         * HashMap is non synchronized.
         * HashMap maintains no order.
         */
        fun HashMapExm() {
            val map = HashMap<Int, String>() //Creating HashMap
            map[1] = "Mango" //Put elements in Map
            map[2] = "Apple"
            map[3] = "Banana"
            map[1] = "Grapes" //trying duplicate key
            for ((key, value) in map) {
                Log.d("HashMap", "$key $value")
            }
        }

        /**
         * TreeMap contains only unique elements.
         * TreeMap cannot have a null key but can have multiple null values.
         * TreeMap is non synchronized.
         * TreeMap maintains ascending order.
         */
        fun TreeMapExm() {
            val map = TreeMap<Int, String>()
            map[100] = "Amit"
            map[102] = "Ravi"
            map[101] = "Vijay"
            map[103] = "Rahul"
            for ((key, value) in map) {
                Log.d("TreeMap", "$key $value")
            }
        }

        /**
         * Hashtable class contains unique elements.
         * Hashtable class doesn't allow null key or value.
         * Hashtable class is synchronized.
         */
        fun HashTableExm() {
            val hm = Hashtable<Int, String>()
            hm[100] = "Amit"
            hm[102] = "Ravi"
            hm[101] = "Vijay"
            hm[103] = "Rahul"
            for ((key, value) in hm) {
                Log.d("HashTable", "$key $value")
            }
        }

        /**
         * But it does not orders the elements in FIFO manner.
         *
         */
        fun ProrityQueueExm() {
            val queue = PriorityQueue<String>()
            queue.add("Amit")
            queue.add("Vijay")
            queue.add("Karan")
            queue.add("Jai")
            queue.add("Rahul")
            Log.d("", "head:" + queue.element())
            Log.d("", "head:" + queue.peek())
            for (s in queue) {
                Log.d("PriorityQueue", "" + s)
            }
        }


    }

