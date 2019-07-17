package com.example.rahul.todo.tools

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rahul.todo.databinding.TodoListItemViewBinding
import com.example.rahul.todo.service.dto.TodoListDto

class TodoAdapter : ListAdapter<TodoListDto, TodoViewHolder>(TodoListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class TodoListDiffCallback : DiffUtil.ItemCallback<TodoListDto>() {
    override fun areItemsTheSame(oldItem: TodoListDto, newItem: TodoListDto): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TodoListDto, newItem: TodoListDto): Boolean {
        return oldItem == newItem
    }
}

class TodoViewHolder(val binding: TodoListItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TodoListDto) {
        binding.title.text = item.title
        val todos = item.todoList.filter { !it.isChecked }.take(2)

        if (!todos.isEmpty())
            binding.todo1.text = todos[0].todo

        if (todos.size > 1)
            binding.todo2.text = todos[1].todo
    }

    companion object {
        fun from(parent: ViewGroup): TodoViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = TodoListItemViewBinding.inflate(layoutInflater, parent, false)
            return TodoViewHolder(binding)
        }
    }
}
