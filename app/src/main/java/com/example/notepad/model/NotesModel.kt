package com.example.notepad.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "NotesTable")
class NotesModel {
    @PrimaryKey(autoGenerate = true)
    val Id: Int?=null
    @ColumnInfo(name="Titles")
    val titles:String?=null
    val contents: String?=null
}