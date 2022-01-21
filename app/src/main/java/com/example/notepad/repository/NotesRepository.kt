package com.example.notepad.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.notepad.database.NoteDatabase
import com.example.notepad.interfaces.EndUrl
import com.example.notepad.model.AddNotes
import com.example.notepad.utils.NetworkUtils

class NotesRepository {
    private val quoteService: EndUrl?=null
    private val quoteDatabase: NoteDatabase?=null
    private val applicationContext: Context?=null



    private val quotesLiveData = MutableLiveData<AddNotes>()

    val quotes: LiveData<AddNotes>?=null

    suspend fun getQuotes(page: Int){

        if(applicationContext?.let { NetworkUtils.isInternetAvailable(it) } == true){
            val result = quoteService?.getNewNotes()
            if(result?.body() != null){
               // quoteDatabase?.wordDao()?.insert(result.body()!!)
              //  quoteDatabase?.wordDao()?.insert(result.body()!!.getContent())
            }
        }
        else{
          //  val quotes = quoteDatabase?.wordDao()?.insert(this)
//            val quoteList = QuoteList(1,1,1,quotes, 1, 1)
            //quotesLiveData.postValue(quoteList)
        }

    }

}