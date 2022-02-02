package com.example.notepad.kotlinbasics.classesandObjects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notepad.R

class OopsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oops)
        val inheritance=Inheritance()
        inheritance.main()
        inheritance.mains()
    }
}