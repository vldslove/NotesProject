package com.example.an10_onl.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.an10_onl.model.Note
import com.example.an10_onl.model.User
import com.example.an10_onl.repositories.NoteRepository
import com.example.an10_onl.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val noteRepository : NoteRepository,
    private val userRepository : UserRepository
) : ViewModel() {

    val listUsers = MutableLiveData<ArrayList<User>>()

    companion object {
        const val none = "0 note"
    }

    suspend fun getSize(): Int {
        return noteRepository.getListSize()
    }

    fun deleteNotes() {
        var list : List<Note>
        viewModelScope.launch {
            list = noteRepository.getListNotes()
            noteRepository.deleteList(list)
        }
    }

    fun userDelete(user: User) {
        viewModelScope.launch {
            userRepository.deleteUser(user)
        }
    }

    fun getUsers() {
        viewModelScope.launch {
            listUsers.postValue(userRepository.getAllUsers())
        }
    }


}