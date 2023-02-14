package com.example.an10_onl.ui.listNote.noteadapter

import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.an10_onl.model.Note
import com.example.an10_onl.R

typealias callback = (note: Note)-> Unit
class NoteListViewHolder(private val view: View, val handleDelete: callback, val showNoteInfo: callback, val shareNote: callback) : RecyclerView.ViewHolder(view) {

    fun showNotes(note: Note) {
        view.findViewById<Button>(R.id.deleteButton2).setOnClickListener {
        }
        view.apply {
            findViewById<TextView>(R.id.title).text = note.title
            findViewById<TextView>(R.id.message).text = note.message
            findViewById<TextView>(R.id.date).text = note.date
            findViewById<Button>(R.id.shareButton).setOnClickListener {
                shareNote(note)
            }
            findViewById<Button>(R.id.deleteButton2).setOnClickListener {
                handleDelete(note)
            }
            findViewById<LinearLayout>(R.id.notes_layout).setOnClickListener{
                showNoteInfo(note)

            }

        }

    }


}

