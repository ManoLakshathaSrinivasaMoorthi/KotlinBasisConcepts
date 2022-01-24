package com.example.notepad.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding= DataBindingUtil. setContentView(this,R.layout.activity_add_notes_by_retrofit)
      viewModel= ViewModelProvider(this)[NotesViewModel::class.java]
        getNewNotes()
    }

    private fun getNewNotes() {
       binding.buttonSave.setOnClickListener {
           val contents=Content()
            contents.setNotes(binding.editTextBody.text.toString())
//           contents.setMobileno("+9047310589")
           viewModel.addNewNotes(contents)?.observe(this){responses->
               Log.d("AddNotes", "Response: \n "+ Gson().toJson(responses))
             if(responses?.getStatusCode()?.equals("200") == true){
//                 viewModel.readNotes()?.observe(this){
//
//                 }
               val intent=Intent(this,ReadNotesByRetrofit::class.java)
                 intent.putExtra("",responses.getContent().toString())
                 startActivity(intent)
             }
           }
       }

    }


}