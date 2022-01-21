package com.example.notepad.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.notepad.model.AddNotes

@Dao
interface NoteDao {
    @Insert
    suspend fun addQuote(quotes: AddNotes?)
}
