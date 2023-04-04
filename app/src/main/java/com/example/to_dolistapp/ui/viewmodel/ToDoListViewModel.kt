package com.example.to_dolistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_dolistapp.data.ToDoEntity
import com.example.to_dolistapp.data.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoListViewModel
@Inject
constructor(private val repository: TodoRepository) : ViewModel() {
    private val _todos = MutableStateFlow(listOf<ToDoEntity>())
    val todos = _todos.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>("")
    val errorMessage = _errorMessage.asStateFlow()

    init {
        getTodos()
    }

    fun getTodos() {
        viewModelScope.launch {
            try {
                _todos.value = repository.getTodos()
            } catch (e: Exception) {
                _errorMessage.value = "Error: ${e.message} while getting todos"
            }
        }
    }

    fun insertTodo(todo: ToDoEntity) {
        viewModelScope.launch {
            try {
                repository.insertTodo(todo)
                getTodos()
            } catch (e: Exception) {
                _errorMessage.value = "Error: ${e.message} while inserting"
            }
        }
    }

    fun deleteTodo(todo: ToDoEntity) {
        viewModelScope.launch {
            try {
                repository.deleteTodo(todo)
                getTodos()
            } catch (e: Exception) {
                _errorMessage.value = "Error: ${e.message} while deleting"
            }
        }
    }
}