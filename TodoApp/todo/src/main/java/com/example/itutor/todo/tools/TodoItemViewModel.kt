package com.example.itutor.todo.tools

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itutor.todo.service.dto.TodoListDto
import com.example.itutor.todo.service.model.TodoList
import java.lang.IllegalArgumentException

class TodoItemViewModel(todoList: TodoList): ViewModel() {

    private var _todoList: MutableLiveData<TodoList> = MutableLiveData()

    val todoList: LiveData<TodoList>
        get() = _todoList

    init {
        this._todoList.value = todoList
    }
}

class TodoItemViewModelFactory(val todoList: TodoList): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return (TodoItemViewModel(todoList) as? T) ?: throw IllegalArgumentException()
    }
}
