package com.example.itutor.todo.tools

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.itutor.todo.databinding.TodoItemsViewBinding
import com.example.itutor.todo.service.model.Todo

class TodoItemAdapter(private val onItemClick: (Todo) -> Unit) :
    ListAdapter<Todo, TodoItemViewHolder>(TodoItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        return TodoItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick, position)
    }
}

class TodoItemDiffCallback : DiffUtil.ItemCallback<Todo>() {
    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem == newItem
    }
}

class TodoItemViewHolder(private val binding: TodoItemsViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Todo, onItemClick: (Todo) -> Unit, position: Int) {
//        binding.checkbox.isChecked = item.isChecked
//        binding.title.text = item.todo
        binding.item = item
        binding.title.setOnClickListener {
            binding.checkbox.isChecked = !binding.checkbox.isChecked
            Log.e("CHECKED", "${item.isChecked}")
        }
        binding.detailsBtn.setOnClickListener {
            onItemClick(item)
        }
    }

    companion object {
        fun from(parent: ViewGroup): TodoItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = TodoItemsViewBinding.inflate(layoutInflater, parent, false)
            return TodoItemViewHolder(binding)
        }
    }
}