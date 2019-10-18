package com.example.itutor.todo.service.model

import com.example.itutor.todo.service.dto.TodoListDto

data class TodoList(
    val title: String,
    val todoList: List<Todo>,
    val color: String = "ffffa040",
    val photo: String? = null
) {
    companion object {
        fun get(dto: TodoListDto): TodoList {
            return TodoList(dto.title, dto.todoList.map { Todo.get(it) }.sortedBy { it.isChecked }, dto.color, dto.photo)
        }
    }
}