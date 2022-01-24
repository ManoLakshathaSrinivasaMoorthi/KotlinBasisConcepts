package com.example.notepad.interfaces

import com.example.notepad.model.AddNotes
import com.example.notepad.model.Content
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface EndUrl {

    @POST("/dev/notes/add")
     fun  getNewNotes(@Body contents: Content?): Call<AddNotes?>?

//    @POST("/dev/notes/get")
//    fun getReadNotes(mobileno: String): Call<AddNotes?>?

}