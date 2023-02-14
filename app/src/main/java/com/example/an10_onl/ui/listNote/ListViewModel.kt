package com.example.an10_onl.ui.listNote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.an10_onl.model.Note
import com.example.an10_onl.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository : NoteRepository
): ViewModel() {


    val listNote = MutableLiveData<ArrayList<Note>>()

    fun getList() {
        viewModelScope.launch {
            listNote.value = repository.getListNotes()
        }
    }

    fun deleteNote(id: Int, title: String, message: String, date: String){
        viewModelScope.launch {
            repository.deleteNote(Note(id, title, message, date))
        }
    }

}