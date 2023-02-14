package com.example.an10_onl.ui.listNote.noteadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.an10_onl.model.Note
import com.example.an10_onl.R

class NoteListAdapter(
    private val onClick: callback, val handleDelete: callback, val shareNote: callback
) : RecyclerView.Adapter<NoteListViewHolder>() {

    private var list = arrayListOf<Note>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteListViewHolder {
        return NoteListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false),
            handleDelete,
            showNoteInfo = onClick,
            shareNote
        )
    }

    override fun onBindViewHolder(holder: NoteListViewHolder, position: Int) {
        holder.showNotes(list[position])
        holder.itemView.setOnClickListener {
            onClick(list[position])
        }
    }

    override fun getItemCount() = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Note>) {
        this.list = list
        notifyDataSetChanged()
    }

}

