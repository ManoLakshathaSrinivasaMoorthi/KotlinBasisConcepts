package com.example.notepad.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.notepad.R
import com.example.notepad.databinding.ActivityReadNotesByRetrofitBinding
import com.example.notepad.viewmodel.NotesViewModel
import com.google.gson.Gson

class ReadNotesByRetrofit : AppCompatActivity() {
    private lateinit var binding:ActivityReadNotesByRetrofitBinding
    private  lateinit var  viewModel:NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding=DataBindingUtil.  setContentView(this,R.layout.activity_read_notes_by_retrofit)
        viewModel= ViewModelProvider(this)[NotesViewModel::class.java]
        getIntests()
    }

    private fun getIntests() {


//        viewModel.readNotes(body)?.observe(this){ response->
//            Log.d("ReadNotes", "Response: \n "+ Gson().toJson(response))
//            binding.MobileNo.text = response?.getMobileno()
//        }

    }
}