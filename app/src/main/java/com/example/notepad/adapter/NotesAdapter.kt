package com.example.notepad.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notepad.R
import com.example.notepad.model.Content

class NotesAdapter(private var context: Context?, messages: List<Content>?,private var teamNameArrayList: List<String>?) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    private var messages: List<Content>? = messages

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.notes_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val consultMessage: Content = messages!![position]
        holder.note.text = consultMessage.getNotes()
        holder.contenttime.text = consultMessage.getCreatedtime()
    }

    override fun getItemCount(): Int {
        return messages!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var note:TextView=itemView.findViewById(R.id.textnote)
         var contenttime:TextView=itemView.findViewById(R.id.texttime)

    }
}