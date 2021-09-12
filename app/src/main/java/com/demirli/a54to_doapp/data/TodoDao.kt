package com.demirli.a54to_doapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demirli.a54to_doapp.model.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM todos")
    fun getAllTodos(): LiveData<List<Todo>>

    @Query("SELECT * FROM todos WHERE todo_is_complated= :todo_is_complated")
    fun getAllTodosAccToComplated(todo_is_complated: Boolean): LiveData<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTodo(todo: Todo)

}