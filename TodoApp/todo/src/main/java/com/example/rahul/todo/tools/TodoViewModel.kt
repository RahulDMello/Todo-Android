package com.example.rahul.todo.tools

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rahul.todo.service.TodoRepository
import com.example.rahul.todo.service.dto.TodoListDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoViewModel: ViewModel() {
    private val scope = CoroutineScope(Dispatchers.Default)
    private val repository = TodoRepository()
    private var _todos = MutableLiveData<List<TodoListDto>>()

    var selectedTodoIndex = MutableLiveData<Int>()

    val todos: LiveData<List<TodoListDto>>
        get() = _todos

    init {
        scope.launch {
            _todos.postValue(repository.getRegularTodos())
        }
    }

}