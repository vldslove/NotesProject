package com.example.an10_onl.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    @ColumnInfo (name= "title")
    val title:String,
    @ColumnInfo (name= "message")
    val message:String,
    @ColumnInfo (name= "date")
    val date: String
)
