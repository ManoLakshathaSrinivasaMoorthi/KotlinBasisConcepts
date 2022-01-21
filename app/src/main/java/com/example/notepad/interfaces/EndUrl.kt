package com.example.notepad.interfaces

import com.example.notepad.model.AddNotes
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface EndUrl {

    @POST("/dev/notes/add")
    suspend fun  getNewNotes(@Query("notes") patient: Int):Response<AddNotes>


}