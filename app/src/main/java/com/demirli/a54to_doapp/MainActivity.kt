package com.demirli.a54to_doapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.demirli.a54to_doapp.model.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TodoAdapter.OnUserClickOnComplatedButton, TodoComplatedAdapter.OnUserClickOnUnComplatedButton {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: TodoAdapter
    private lateinit var adapter_complated: TodoComplatedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = MainViewModel(application)

        val llm = LinearLayoutManager(this)
        val llmComp = LinearLayoutManager(this)
        llmComp.stackFromEnd = true
        llmComp.reverseLayout = true
        todo_recyclerView.layoutManager = llm
        todo_complated_recyclerView.layoutManager = llmComp

        viewModel.getAllTodosAccToComplated(false).observe(this, Observer {
            adapter = TodoAdapter(it,this)
            todo_recyclerView.adapter = adapter
        })

        viewModel.getAllTodosAccToComplated(true).observe(this, Observer {
            adapter_complated = TodoComplatedAdapter(it, this)
            todo_complated_recyclerView.adapter = adapter_complated
        })

        add_btn.setOnClickListener {
            addTodo()
        }

    }

    fun addTodo(){
        val todo = Todo(todo_title = todo_editText.text.toString(),todo_is_complated = false)
        viewModel.addTodo(todo)
    }

    override fun onClickOnComplatedButton(todo: Todo) {
        val modifiedTodo = Todo(todo.todo_id, todo.todo_title, true)
        viewModel.addTodo(modifiedTodo)
    }

    override fun onClickOnUnComplatedButton(todo: Todo) {
        val modifiedTodo = Todo(todo.todo_id, todo.todo_title, false)
        viewModel.addTodo(modifiedTodo)
    }
}
