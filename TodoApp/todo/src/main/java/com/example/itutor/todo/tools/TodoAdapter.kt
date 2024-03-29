package com.example.itutor.todo.tools

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.itutor.todo.databinding.TodoListItemViewBinding
import com.example.itutor.todo.service.model.TodoList

class TodoAdapter(private val onItemClick: (Int) -> Unit) :
    ListAdapter<TodoList, TodoViewHolder>(TodoListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick, position)
    }

}

class TodoListDiffCallback : DiffUtil.ItemCallback<TodoList>() {
    override fun areItemsTheSame(oldItem: TodoList, newItem: TodoList): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: TodoList, newItem: TodoList): Boolean {
        return oldItem == newItem
    }
}

class TodoViewHolder(private val binding: TodoListItemViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TodoList, onItemClick: (Int) -> Unit, position: Int) {
        binding.item = item
        @Suppress("SpellCheckingInspection")
        val todos = item.todoList.filter { !it.isChecked }.take(2)

        if (todos.isNotEmpty())
            binding.todo1.text = todos[0].todo

        if (todos.size > 1)
            binding.todo2.text = todos[1].todo

        binding.card.setCardBackgroundColor(item.color.toColorInt())

        binding.card.setOnClickListener {
            onItemClick(position)
        }

    }

    companion object {
        fun from(parent: ViewGroup): TodoViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = TodoListItemViewBinding.inflate(layoutInflater, parent, false)
            return TodoViewHolder(binding)
        }
    }
}
