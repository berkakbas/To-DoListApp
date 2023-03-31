package com.example.to_dolistapp.data

import javax.inject.Inject

class TodoRepository
@Inject
constructor(private val database: TodoDatabase) {

    suspend fun getTodos(): List<ToDoEntity> {
        return database.todoDao().getTodos()
    }

    suspend fun insertTodo(todo: ToDoEntity) {
        database.todoDao().insert(todo)
    }

    suspend fun updateTodo(newTodo: ToDoEntity) {
        database.todoDao().updateTodo(newTodo)
    }

    suspend fun deleteTodo(todo: ToDoEntity) {
        database.todoDao().deleteTodo(todo)
    }
}