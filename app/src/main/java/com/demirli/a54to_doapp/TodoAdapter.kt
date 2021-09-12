package com.demirli.a54to_doapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demirli.a54to_doapp.model.Todo
import com.google.android.material.button.MaterialButton

class TodoAdapter(var todoList: List<Todo>, var onUserClickOnComplatedButton: OnUserClickOnComplatedButton): RecyclerView.Adapter<TodoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.todoTitle.setText(todoList[position].todo_title)

        holder.completedButton.setOnClickListener {
            onUserClickOnComplatedButton.onClickOnComplatedButton(todoList[position])
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val todoTitle = view.findViewById<TextView>(R.id.todo_title_tv)
        val completedButton = view.findViewById<MaterialButton>(R.id.completed_btn)
    }

    interface OnUserClickOnComplatedButton{
        fun onClickOnComplatedButton(todo: Todo)
    }

}