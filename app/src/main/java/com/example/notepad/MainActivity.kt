package com.example.notepad

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notepad.adapter.NotesAdapter
import com.example.notepad.database.NoteDatabase
import com.example.notepad.databinding.ActivityMainBinding
import com.example.notepad.model.Content
import com.example.notepad.utils.Constant
import com.example.notepad.view.AddNotesByRetrofit
import com.example.notepad.view.ReadNotesByRetrofit
import com.example.notepad.viewmodel.NotesViewModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private  lateinit var  viewModel: NotesViewModel
    private lateinit var appDatabase: NoteDatabase


    private lateinit var adapter:NotesAdapter

   private var teamNameArrayList: MutableList<String>? = null
private val texts:ArrayList<Content>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil. setContentView(this,R.layout.activity_main)
        viewModel= ViewModelProvider(this)[NotesViewModel::class.java]

        appDatabase = NoteDatabase.getDatabase(this)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.notesList.layoutManager = linearLayoutManager

        setIntents()
        getIntents()

    }

    private fun getIntents() {
        val bundle=intent.extras
        val notes=Content()
        notes.setMobileno(bundle?.getString(Constant.Intentkeys.NOTES_MOBILE))

        viewModel.readNotes(notes.getMobileno().toString())?.observe(this, { response ->

            if (response != null) {

//                val intent=Intent(this, ReadNotesByRetrofit::class.java)
//                intent.putExtra("",response.getContent()?.getNotes())
//                startActivity(intent)
                adapter= NotesAdapter(this, texts,teamNameArrayList)
                binding.notesList.adapter=adapter
            }
        })


    }

    private fun setIntents() {

        binding.floatingActionButton.setOnClickListener {
            val intent= Intent(this,AddNotesByRetrofit::class.java)
            startActivity(intent)
        }


    }



}