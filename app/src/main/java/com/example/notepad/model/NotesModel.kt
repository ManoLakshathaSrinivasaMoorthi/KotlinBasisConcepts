package com.example.notepad.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "quote")
class NotesModel {
    @PrimaryKey(autoGenerate = true)
    val Id: Int?=null
    val titles:String?=null
    val contents: String?=null
}