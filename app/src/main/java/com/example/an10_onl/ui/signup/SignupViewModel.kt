package com.example.an10_onl.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.an10_onl.model.User
import com.example.an10_onl.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignupViewModel @Inject constructor(
    private val repository : UserRepository
) : ViewModel() {



    fun addUser(email: String, password: String, firstName: String, lastName: String) {
        viewModelScope.launch {
            repository.addUser(User(email, password, firstName, lastName))
        }
    }
}