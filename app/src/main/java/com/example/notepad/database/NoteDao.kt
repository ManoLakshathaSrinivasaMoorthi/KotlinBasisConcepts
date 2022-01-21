package com.example.notepad.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.notepad.model.Content

interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Content)
}
