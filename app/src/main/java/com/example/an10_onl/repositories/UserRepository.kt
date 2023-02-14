package com.example.an10_onl.repositories

import com.example.an10_onl.db.UserDao
import com.example.an10_onl.model.User
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun getAllUsers() : ArrayList<User> {
        return userDao.getAllUsers() as ArrayList<User>
    }

    suspend fun getUserEmail(email: String): ArrayList<String>{
        return userDao.selectUserEmail(email) as ArrayList<String>
    }

    suspend fun getUserPassword(password: String): ArrayList<String>{
        return userDao.selectUserPassword(password) as ArrayList<String>
    }

    suspend fun deleteUser(user: User){
        userDao.userDelete(user)
    }

    suspend fun deleteAllUsers(list: List<User>){
        userDao.deleteAllUsers(list)
    }
}