package com.example.to_dolistapp.data

import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos")
    suspend fun getTodos(): List<ToDoEntity>

    @Insert
    suspend fun insert(todo: ToDoEntity)

    @Delete
    suspend fun deleteTodo(todo: ToDoEntity)

    @Update
    suspend fun updateTodo(todo: ToDoEntity)
}