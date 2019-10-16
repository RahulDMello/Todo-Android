package com.example.itutor.todo.tools

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.itutor.todo.databinding.TodoItemsViewBinding
import com.example.itutor.todo.service.dto.TodoDto

class TodoItemAdapter(private val onItemClick: (TodoDto) -> Unit) :
    ListAdapter<TodoDto, TodoItemViewHolder>(TodoItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        return TodoItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick, position)
    }
}

class TodoItemDiffCallback : DiffUtil.ItemCallback<TodoDto>() {
    override fun areItemsTheSame(oldItem: TodoDto, newItem: TodoDto): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: TodoDto, newItem: TodoDto): Boolean {
        return oldItem == newItem
    }
}

class TodoItemViewHolder(private val binding: TodoItemsViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TodoDto, onItemClick: (TodoDto) -> Unit, position: Int) {
        binding.checkbox.isChecked = item.isChecked
        binding.title.text = item.todo
        binding.title.setOnClickListener {
            binding.checkbox.isChecked = !binding.checkbox.isChecked
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