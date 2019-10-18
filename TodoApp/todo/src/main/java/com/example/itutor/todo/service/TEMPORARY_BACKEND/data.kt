package com.example.itutor.todo.service.TEMPORARY_BACKEND

import com.example.itutor.todo.service.dto.TodoDto
import com.example.itutor.todo.service.dto.TodoListDto

object Data {
    val todoListDto = mutableListOf<TodoListDto>(
        TodoListDto("Todo 1", listOf(
            TodoDto(false, "1 todo"),
            TodoDto(false, "2 todo"),
            TodoDto(false, "3 todo"),
            TodoDto(true, "4 todo"),
            TodoDto(false, "5 todo")
        ), "ffffa040"),
        TodoListDto("Todo 2", listOf(
            TodoDto(false, "1 todo"),
            TodoDto(false, "2 todo"),
            TodoDto(false, "3 todo"),
            TodoDto(true, "4 todo"),
            TodoDto(false, "5 todo")
        ), "ff00a040"),
        TodoListDto("Todo 3", listOf(
            TodoDto(false, "1 todo"),
            TodoDto(false, "2 todo"),
            TodoDto(false, "3 todo"),
            TodoDto(true, "4 todo"),
            TodoDto(false, "5 todo")
        ), "ff55a055"),
        TodoListDto("Todo 4", listOf(
            TodoDto(false, "1 todo"),
            TodoDto(false, "2 todo"),
            TodoDto(false, "3 todo"),
            TodoDto(true, "4 todo"),
            TodoDto(false, "5 todo")
        ), "ffaabb11"),
        TodoListDto("Todo 5", listOf(
            TodoDto(false, "1 todo"),
            TodoDto(false, "2 todo"),
            TodoDto(false, "3 todo"),
            TodoDto(true, "4 todo"),
            TodoDto(false, "5 todo")
        ), "ffcccccc"),
        TodoListDto("Todo 6", listOf(
            TodoDto(false, "1 todo"),
            TodoDto(false, "2 todo"),
            TodoDto(false, "3 todo"),
            TodoDto(true, "4 todo"),
            TodoDto(false, "5 todo")
        ), "ff2234ee"),
        TodoListDto("Todo 7", listOf(
            TodoDto(false, "1 todo"),
            TodoDto(false, "2 todo"),
            TodoDto(false, "3 todo"),
            TodoDto(true, "4 todo"),
            TodoDto(false, "5 todo")
        ), "ff040aff"),
        TodoListDto("Todo 8", listOf(
            TodoDto(false, "1 todo"),
            TodoDto(false, "2 todo"),
            TodoDto(false, "3 todo"),
            TodoDto(true, "4 todo"),
            TodoDto(false, "5 todo")
        ), "ffff00dd"),
        TodoListDto("Todo 9", listOf(
            TodoDto(false, "1 todo"),
            TodoDto(false, "2 todo"),
            TodoDto(false, "3 todo"),
            TodoDto(true, "4 todo"),
            TodoDto(false, "5 todo")
        ), "ffaa2267"),
        TodoListDto("Todo 10", listOf(
            TodoDto(false, "1 todo"),
            TodoDto(false, "2 todo"),
            TodoDto(false, "3 todo"),
            TodoDto(true, "4 todo"),
            TodoDto(false, "5 todo")
        ), "ffbb6621")
    )
}