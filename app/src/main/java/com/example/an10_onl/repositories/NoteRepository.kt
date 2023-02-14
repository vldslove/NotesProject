package com.example.an10_onl.repositories

import com.example.an10_onl.db.NoteDao
import com.example.an10_onl.model.Note
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {


    suspend fun getListNotes(): ArrayList<Note> {
        return noteDao.selectAllNote() as ArrayList<Note>
    }

    suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    suspend fun deleteList(list: List<Note>){
        noteDao.deleteAllNotes(list)
    }

    suspend fun getListSize(): Int {
        return noteDao.selectAllNote().size
    }

}