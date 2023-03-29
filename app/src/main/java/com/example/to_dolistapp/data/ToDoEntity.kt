package com.example.to_dolistapp.data

data class ToDoEntity(val note: String, val priority: Primacy)

enum class Primacy {
    LOW, MEDIUM, HIGH
}