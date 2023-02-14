package com.example.an10_onl.ui.search

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.an10_onl.R
import com.example.an10_onl.model.Note

class SearchViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    fun bind(note: Note) {
        view.apply {
            findViewById<TextView>(R.id.title_search).text = note.title
            findViewById<TextView>(R.id.message_search).text = note.message
            findViewById<TextView>(R.id.date_search).text = note.date
        }
    }
}