package com.example.notepad.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notepad.model.Content

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(user: Content?)

    @Query("Select * from Content")
    fun getAllUser():List<Content?>
}
