package com.example.an10_onl.ui.addNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.an10_onl.model.Note
import com.example.an10_onl.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val repository : NoteRepository

): ViewModel(){

    fun addNote(id: Int, title: String, message: String, date: String){
        viewModelScope.launch {
            repository.addNote(Note(id, title, message, date))
        }
    }
}