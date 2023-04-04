package com.example.to_dolistapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.to_dolistapp.R
import com.example.to_dolistapp.data.Primacy
import com.example.to_dolistapp.data.ToDoEntity

class ToDoAdapter(private val context: Context, private val dataset: List<ToDoEntity>) : RecyclerView.Adapter<ToDoAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.todo_text)
        val priorityView: View = view.findViewById(R.id.priority_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.todo_row, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item.note
        when (item.priority) {
            Primacy.HIGH -> holder.priorityView.setBackgroundResource(R.drawable.circle_red)
            Primacy.MEDIUM -> holder.priorityView.setBackgroundResource(R.drawable.circle_orange)
            Primacy.LOW -> holder.priorityView.setBackgroundResource(R.drawable.circle_green)
        }


        val bundle = bundleOf("todo" to item)
        holder.view.setOnClickListener {
            holder.view.findNavController().navigate(R.id.action_toDoListFragment_to_toDoDetailFragment, bundle)
        }
    }

    override fun getItemCount() = dataset.size
}