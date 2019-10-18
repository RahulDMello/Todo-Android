package com.example.itutor.todo.service.model

import com.example.itutor.todo.service.dto.TodoDto

data class Todo(
    var isChecked: Boolean,
    val todo: String
) {
    companion object {
        fun get(todoDto: TodoDto): Todo {
            return Todo(todoDto.isChecked, todoDto.todo)
        }
    }
}