package com.example.an10_onl.repositories

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

private const val USER_PREFERENCES = "user_preferences"
private const val GLOBAL_PREFERENCES = "global_preferences"
private const val USER_NAME = "user_name"

private const val PASSWORD = "password"

@Singleton
class SharedPreferencesRepository @Inject constructor(
    @ApplicationContext context: Context
){
    private val userPreferences =
        context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)

    private val globalPreferences =
        context.getSharedPreferences(GLOBAL_PREFERENCES, Context.MODE_PRIVATE)

    fun setUserName(userName: String) {
        userPreferences.edit {
            putString(USER_NAME, userName)
        }
    }
    fun setUserPassword(password: String) {
        userPreferences.edit {
            putString(PASSWORD, password)
        }
    }
    fun getUserName(): String? {
        return userPreferences.getString(USER_NAME, null)
    }

    fun logout() {
        userPreferences.edit{
            clear()
        }
    }
}