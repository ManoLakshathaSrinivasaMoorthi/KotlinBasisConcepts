package com.example.notepad.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.notepad.MainActivity
import com.example.notepad.R
import com.example.notepad.database.NoteDatabase
import com.example.notepad.databinding.ActivityAddNotesByRetrofitBinding
import com.example.notepad.model.Content
import com.example.notepad.utils.Constant
import com.example.notepad.viewmodel.NotesViewModel
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*

class AddNotesByRetrofit : AppCompatActivity() {
    private lateinit var binding: ActivityAddNotesByRetrofitBinding
    private lateinit var viewModel: NotesViewModel
    private lateinit var appDatabase: NoteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_notes_by_retrofit)
        viewModel = ViewModelProvider(this)[NotesViewModel::class.java]
        appDatabase = NoteDatabase.getDatabase(this)
        getNewNotes()
    }

    private fun getNewNotes() {
        binding.buttonSave.setOnClickListener {
            val contents = Content()
            contents.setNotes(binding.editTextTitle.text.toString() +" "+ binding.editTextBody.text.toString())
            contents.setMobileno(Constant.ACCOUNT_NAME)
            contents.setCreatedtime(timestampToDate())

            viewModel.addNewNotes(contents)?.observe(this) { response ->
                Log.d("AddNotes", "Response: \n " + Gson().toJson(response))
                if (response != null) {
                    response.getContent()?.let {
                        appDatabase.userDao().insertAll(response.getContent())
                        val intent= Intent(this,MainActivity::class.java)
//                        intent.putExtra(Constant.Intentkeys.NOTES_KEY, response.getContent()?.getKey())
//                        intent.putExtra(Constant.Intentkeys.NOTES_TIME,response.getContent()?.getCreatedtime())
//                        intent.putExtra(Constant.Intentkeys.NOTES_CONTENT,response.getContent()?.getNotes())
                        intent.putExtra(Constant.Intentkeys.NOTES_MOBILE,response.getContent()?.getMobileno())
                        startActivity(intent)
                        finish()
                    }

                }

            }
        }
    }


    private fun timestampToDate(): String {
        val df: SimpleDateFormat = SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss")
        return df.format(Calendar.getInstance().time)
    }

}