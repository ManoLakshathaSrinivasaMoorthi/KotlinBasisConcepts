package com.example.notepad.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.notepad.R
import com.example.notepad.databinding.ActivityAddNotesByRetrofitBinding
import com.example.notepad.model.Content
import com.example.notepad.viewmodel.NotesViewModel
import com.google.gson.Gson

class AddNotesByRetrofit : AppCompatActivity() {
    private lateinit var binding:ActivityAddNotesByRetrofitBinding
    private lateinit var  viewModel:NotesViewModel
    private var title:String?=null
    private var body:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding= DataBindingUtil. setContentView(this,R.layout.activity_add_notes_by_retrofit)
      viewModel=ViewModelProvider(this).get(NotesViewModel::class.java)
        getNewNotes()
    }

    private fun getNewNotes() {
       binding.buttonSave.setOnClickListener {
           val contents=contents()
           viewModel.addNewNotes(contents).observe(this){
               val response=it.body()
               Log.d("AddNotes", "NewNote response : " + Gson().toJson(response))
           }
       }

    }

    private fun contents(): Content {
         val notes=Content()
       notes.notes= binding.editTextTitle.toString()


        return notes
    }
}