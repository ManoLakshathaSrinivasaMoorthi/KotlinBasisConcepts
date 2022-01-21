package com.example.notepad.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class AddNotes {

    @SerializedName("statusCode")
    @Expose
    private var statusCode: String? = null

    @SerializedName("message")
    @Expose
    private var message: String? = null

    @SerializedName("content")
    @Expose
    private var content: Content? = null


    constructor()


    constructor(statusCode: String?, message: String?, content: Content?): super() {

        this.statusCode = statusCode
        this.message = message
        this.content = content
    }

    fun getStatusCode(): String? {
        return statusCode
    }

    fun setStatusCode(statusCode: String?) {
        this.statusCode = statusCode
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String?) {
        this.message = message
    }

    fun getContent(): Content? {
        return content
    }

    fun setContent(content: Content?) {
        this.content = content
    }
}
