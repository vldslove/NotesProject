package com.example.an10_onl.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.an10_onl.model.Note

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM Note")
    suspend fun selectAllNote(): List<Note>

    @Delete
    suspend fun deleteAllNotes(list: List<Note>)

}