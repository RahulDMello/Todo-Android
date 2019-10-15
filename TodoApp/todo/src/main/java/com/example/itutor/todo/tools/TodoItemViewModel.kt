package com.example.itutor.todo.tools

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itutor.todo.service.dto.TodoListDto
import java.lang.IllegalArgumentException

class TodoItemViewModel(todoList: TodoListDto): ViewModel() {

    private var _todoList: MutableLiveData<TodoListDto> = MutableLiveData()

    val todoList: LiveData<TodoListDto>
        get() = _todoList

    init {
        this._todoList.value = todoList
    }
}

class TodoItemViewModelFactory(val todoList: TodoListDto): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return (TodoItemViewModel(todoList) as? T) ?: throw IllegalArgumentException()
    }
}
