package com.demirli.a54to_doapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.demirli.a54to_doapp.model.Todo

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository: MainRepository by lazy { MainRepository(application)}

    fun getAllTodos(): LiveData<List<Todo>> = repository.getAllTodos()

    fun getAllTodosAccToComplated(todo_is_complated: Boolean): LiveData<List<Todo>> = repository.getAllTodosAccToComplated(todo_is_complated)

    fun addTodo(todo: Todo) = repository.addTodo(todo)

}