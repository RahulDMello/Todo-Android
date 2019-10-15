package com.example.itutor.todo.service.dto

import kotlinx.serialization.Serializable

@Serializable
data class TodoListDto(
    val title: String,
    val todoList: List<TodoDto>,
    val color: String = "ffffa040",
    val photo: String? = null
)

@Serializable
data class TodoDto (
    val isChecked: Boolean,
    val todo: String
)