package com.example.itutor.todo.service

import com.example.itutor.todo.service.TEMPORARY_BACKEND.Data
import com.example.itutor.todo.service.model.TodoList

class TodoRepository {

    suspend fun getRegularTodos(): MutableList<TodoList> {
        return Data.todoListDto.map { TodoList.get(it) }.toMutableList()
    }
}