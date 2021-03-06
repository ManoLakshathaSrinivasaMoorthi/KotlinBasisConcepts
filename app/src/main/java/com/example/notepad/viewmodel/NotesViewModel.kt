package com.example.notepad.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.notepad.apiClient.RetrofitClient
import com.example.notepad.database.NoteDatabase
import com.example.notepad.interfaces.EndUrl
import com.example.notepad.model.AddNotes
import com.example.notepad.model.Content
import retrofit2.Response

class NotesViewModel:ViewModel() {
    private var patientObservable: MutableLiveData<AddNotes>? = null
    private lateinit var retService: EndUrl
    private lateinit var database:NoteDatabase

    fun addNewNotes( patient: Int): LiveData<Response<AddNotes>> =  liveData  {
        retService = RetrofitClient.getretrofit()
            .create(EndUrl::class.java)
        patientObservable = MutableLiveData<AddNotes>()
          database.wordDao().insert(patient)
        val response = retService.getNewNotes(patient)
        emit(response)
        return@liveData
    }



}