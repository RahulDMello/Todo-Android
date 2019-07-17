package com.example.rahul.todo.service

import com.example.rahul.todo.service.dto.TodoDto
import com.example.rahul.todo.service.dto.TodoListDto

class TodoRepository {

    suspend fun getRegularTodos(): List<TodoListDto> {
        return mutableListOf<TodoListDto>(
            TodoListDto("Todo 1", listOf(
                TodoDto(false, "1 todo"),
                TodoDto(false, "2 todo"),
                TodoDto(false, "3 todo"),
                TodoDto(true, "4 todo"),
                TodoDto(false, "5 todo")
            )),
            TodoListDto("Todo 2", listOf(
                TodoDto(false, "1 todo"),
                TodoDto(false, "2 todo"),
                TodoDto(false, "3 todo"),
                TodoDto(true, "4 todo"),
                TodoDto(false, "5 todo")
            )),
            TodoListDto("Todo 3", listOf(
                TodoDto(false, "1 todo"),
                TodoDto(false, "2 todo"),
                TodoDto(false, "3 todo"),
                TodoDto(true, "4 todo"),
                TodoDto(false, "5 todo")
            )),
            TodoListDto("Todo 4", listOf(
                TodoDto(false, "1 todo"),
                TodoDto(false, "2 todo"),
                TodoDto(false, "3 todo"),
                TodoDto(true, "4 todo"),
                TodoDto(false, "5 todo")
            )),
            TodoListDto("Todo 5", listOf(
                TodoDto(false, "1 todo"),
                TodoDto(false, "2 todo"),
                TodoDto(false, "3 todo"),
                TodoDto(true, "4 todo"),
                TodoDto(false, "5 todo")
            )),
            TodoListDto("Todo 6", listOf(
                TodoDto(false, "1 todo"),
                TodoDto(false, "2 todo"),
                TodoDto(false, "3 todo"),
                TodoDto(true, "4 todo"),
                TodoDto(false, "5 todo")
            )),
            TodoListDto("Todo 7", listOf(
                TodoDto(false, "1 todo"),
                TodoDto(false, "2 todo"),
                TodoDto(false, "3 todo"),
                TodoDto(true, "4 todo"),
                TodoDto(false, "5 todo")
            )),
            TodoListDto("Todo 8", listOf(
                TodoDto(false, "1 todo"),
                TodoDto(false, "2 todo"),
                TodoDto(false, "3 todo"),
                TodoDto(true, "4 todo"),
                TodoDto(false, "5 todo")
            )),
            TodoListDto("Todo 9", listOf(
                TodoDto(false, "1 todo"),
                TodoDto(false, "2 todo"),
                TodoDto(false, "3 todo"),
                TodoDto(true, "4 todo"),
                TodoDto(false, "5 todo")
            )),
            TodoListDto("Todo 10", listOf(
                TodoDto(false, "1 todo"),
                TodoDto(false, "2 todo"),
                TodoDto(false, "3 todo"),
                TodoDto(true, "4 todo"),
                TodoDto(false, "5 todo")
            ))
        )
    }
}