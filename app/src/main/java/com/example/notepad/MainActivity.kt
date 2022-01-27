package com.example.notepad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notepad.adapter.NotesAdapter
import com.example.notepad.databinding.ActivityMainBinding
import com.example.notepad.model.AddNotes
import com.example.notepad.model.Content
import com.example.notepad.utils.Constant
import com.example.notepad.view.AddNotesByRetrofit
import com.example.notepad.viewmodel.NotesViewModel
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private  lateinit var  viewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil. setContentView(this,R.layout.activity_main)
        viewModel= ViewModelProvider(this).get(NotesViewModel::class.java)
        setIntents()
        getIntentss()
    }

    private fun getIntentss() {

    }

    private fun setIntents() {

        viewModel.readNotes()?.observe(this){ response->
            Log.d("ReadNotes", "Response: \n "+ Gson().toJson(response))
               setNotes(response);
        }

        binding.floatingActionButton.setOnClickListener {
            val intent= Intent(this,AddNotesByRetrofit::class.java)
            startActivity(intent)
        }
        binding.notesList.layoutManager = LinearLayoutManager(this)

    }

    private fun setNotes(response: AddNotes?) {
        val adapter=NotesAdapter(this, response?.getContent() as List<Content>)
        binding.notesList.adapter=adapter
    }
}