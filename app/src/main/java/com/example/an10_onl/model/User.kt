package com.example.an10_onl.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["email"])
data class User(
    @ColumnInfo
    val email: String,
    @ColumnInfo (name = "password")
    val password: String,
    @ColumnInfo (name = "firstname")
    val firstName: String,
    @ColumnInfo (name = "lastname")
    val lastName: String
)