package com.example.to_dolistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "todos")
data class ToDoEntity(
    @PrimaryKey val note: String,
    @ColumnInfo val priority: Primacy
): Serializable

enum class Primacy {
    LOW, MEDIUM, HIGH
}