package com.example.an10_onl.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.an10_onl.model.User

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: User)

    @Query ("SELECT * FROM user")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT email FROM User WHERE email LIKE :email")
    suspend fun selectUserEmail(email: String): List<String>

    @Query("SELECT password FROM User WHERE password LIKE :password")
    suspend fun selectUserPassword(password: String): List<String>

    @Delete
    suspend fun userDelete(user: User)

    @Delete
    suspend fun deleteAllUsers(list: List<User>)
}