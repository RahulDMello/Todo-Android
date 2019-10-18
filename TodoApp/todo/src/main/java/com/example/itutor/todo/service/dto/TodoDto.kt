package com.example.itutor.todo.service.dto

import kotlinx.serialization.Serializable

@Serializable
data class TodoDto (
    var isChecked: Boolean,
    val todo: String
)