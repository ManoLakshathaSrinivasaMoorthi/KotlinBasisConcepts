package com.example.notepad.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Content {

    @SerializedName("key")
    @Expose
    private var key: String? = null

    @SerializedName("createdtime")
    @Expose
    private var createdtime: String? = null

    @SerializedName("notes")
    @Expose
     var notes: String? = null

    @SerializedName("mobileno")
    @Expose
    private var mobileno: String? = null


    constructor() {}


    constructor(key: String?, createdtime: String?, notes: String?, mobileno: String?) :super(){

        this.key = key
        this.createdtime = createdtime
        this.notes = notes
        this.mobileno = mobileno
    }

    fun getKey(): String? {
        return key
    }

    fun setKey(key: String?) {
        this.key = key
    }

    fun getCreatedtime(): String? {
        return createdtime
    }

    fun setCreatedtime(createdtime: String?) {
        this.createdtime = createdtime
    }

    @JvmName("getNotes1")
    fun getNotes(): String? {
        return notes
    }

    @JvmName("setNotes1")
    fun setNotes(notes: String?) {
        this.notes = notes
    }

    fun getMobileno(): String? {
        return mobileno
    }

    fun setMobileno(mobileno: String?) {
        this.mobileno = mobileno
    }
}
