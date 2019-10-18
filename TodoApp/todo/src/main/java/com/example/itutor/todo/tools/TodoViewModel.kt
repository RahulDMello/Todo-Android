package com.example.itutor.todo.tools

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.itutor.todo.service.TodoRepository
import com.example.itutor.todo.service.model.TodoList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    private val scope = CoroutineScope(Dispatchers.Default)
    private val repository = TodoRepository()
    private var _todos = MutableLiveData<MutableList<TodoList>>()

    var selectedTodoIndex = MutableLiveData<Int>()

    val todos: LiveData<MutableList<TodoList>>
        get() = _todos

    init {
        scope.launch {
            _todos.postValue(repository.getRegularTodos())
        }
    }

    fun addTodoList(item: TodoList) {
        _todos.add(item)
    }

}