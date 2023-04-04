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
class ToDoDetailViewModel
@Inject
constructor(private val repository: TodoRepository) : ViewModel() {
    private lateinit var _todo: MutableStateFlow<ToDoEntity>
    val todo = _todo.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>("")
    val errorMessage = _errorMessage.asStateFlow()

    fun updateTodo(todo: ToDoEntity) {
        viewModelScope.launch {
            try {
                repository.updateTodo(todo)
            } catch (e: Exception) {
                _errorMessage.value = "Error: ${e.message} while updating"
            }
        }
    }
}