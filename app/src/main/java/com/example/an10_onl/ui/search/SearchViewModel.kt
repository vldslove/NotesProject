package com.example.an10_onl.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.an10_onl.model.Note
import com.example.an10_onl.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository : NoteRepository
): ViewModel() {

    val listNote = MutableLiveData<ArrayList<Note>>()

    val searchResult = MutableLiveData<ArrayList<Note>>()

    fun getList(){
        viewModelScope.launch {
            listNote.value = repository.getListNotes()
        }
    }

    fun searchNote(searchText: String) {
       viewModelScope.launch {
           searchResult.value = repository.getListNotes().filter {
               it.title.contains(searchText) || it.message.contains(searchText)
           } as ArrayList<Note>
       }
    }
}