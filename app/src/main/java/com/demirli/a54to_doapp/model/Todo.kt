package com.demirli.a54to_doapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var todo_id: Int = 0,
    var todo_title: String,
    var todo_is_complated: Boolean
) {
}