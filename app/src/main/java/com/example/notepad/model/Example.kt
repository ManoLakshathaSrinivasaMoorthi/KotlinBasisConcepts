package com.example.notepad.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class Example (

    @SerializedName("status")
    @Expose
    var status: String? = null,

    @SerializedName("totalResults")
    @Expose
    var totalResults: Int? = null,

    @SerializedName("articles")
    @Expose
    var articles: List<Articles>? = null
)
