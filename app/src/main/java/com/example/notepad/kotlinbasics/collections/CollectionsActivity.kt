package com.example.notepad.kotlinbasics.collections

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notepad.R

class CollectionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collections)
        ImmutableMutableCollection().immutableList()
        ImmutableMutableCollection().immutableMap()
        ImmutableMutableCollection().immutableSet()
        ImmutableMutableCollection().mutableList()
        ImmutableMutableCollection().mutableSet()
        ImmutableMutableCollection().mutableMap()

    }
}