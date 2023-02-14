package com.example.an10_onl.ui.login

import androidx.lifecycle.ViewModel
import com.example.an10_onl.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository : UserRepository
) : ViewModel() {


    suspend fun getUserEmail(email: String): ArrayList<String>{
        return repository.getUserEmail(email)
    }
    suspend fun getUserPassword(password: String): ArrayList<String>{
        return repository.getUserPassword(password)
    }
}