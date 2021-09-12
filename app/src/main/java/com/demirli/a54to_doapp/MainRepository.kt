package com.demirli.a54to_doapp

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.demirli.a54to_doapp.data.TodoDao
import com.demirli.a54to_doapp.data.TodoDb
import com.demirli.a54to_doapp.model.Todo

class MainRepository(context: Context) {

    private val db by lazy{ TodoDb.getInstance(context)}
    private val dao by lazy{db.todoDao()}

    fun getAllTodos(): LiveData<List<Todo>> = dao.getAllTodos()

    fun getAllTodosAccToComplated(todo_is_complated: Boolean): LiveData<List<Todo>> = dao.getAllTodosAccToComplated(todo_is_complated)

    fun addTodo(todo: Todo) = AddTodoAsyncTask(dao).execute(todo)

    private class AddTodoAsyncTask(val dao: TodoDao): AsyncTask<Todo, Void, Void>(){
        override fun doInBackground(vararg params: Todo?): Void? {
            dao.addTodo(params[0]!!)
            return null
        }
    }

}