package com.example.an10_onl.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.an10_onl.model.Note
import com.example.an10_onl.model.User

@Database(entities = [Note::class, User::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun noteDao(): NoteDao

    abstract fun userDao(): UserDao

}