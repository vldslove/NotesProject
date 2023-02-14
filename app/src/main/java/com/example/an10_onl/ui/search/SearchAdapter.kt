package com.example.an10_onl.ui.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.an10_onl.R
import com.example.an10_onl.model.Note

class SearchAdapter : RecyclerView.Adapter<SearchViewHolder>() {

    private var searchList = arrayListOf<Note>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.search_item_notes, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    override fun getItemCount() = searchList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Note>) {
        this.searchList = list
        notifyDataSetChanged()
    }
}