package com.example.notepad.interfaces

import com.example.notepad.model.AddNotes
import com.example.notepad.model.Content
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface EndUrl {

    @POST("add")
     fun  getNewNotes(@Body contents: Content?): Call<AddNotes?>?

    @GET("get")
    fun getReadNotes(@Query("mobileno") notes: String): Call<AddNotes?>?

    //?mobileno=+919597580128
}