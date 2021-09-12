package com.demirli.a54to_doapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demirli.a54to_doapp.model.Todo
import com.google.android.material.button.MaterialButton

class TodoComplatedAdapter(var todoComplatedList: List<Todo>, var onUserClickOnUnComplatedButton: OnUserClickOnUnComplatedButton): RecyclerView.Adapter<TodoComplatedAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_completed_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = todoComplatedList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.todoTitle.setText(todoComplatedList[position].todo_title)

        holder.completedButton.setOnClickListener {
            onUserClickOnUnComplatedButton.onClickOnUnComplatedButton(todoComplatedList[position])
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val todoTitle = view.findViewById<TextView>(R.id.todo_title_tv)
        val completedButton = view.findViewById<MaterialButton>(R.id.completed_btn)
    }

    interface OnUserClickOnUnComplatedButton{
        fun onClickOnUnComplatedButton(todo: Todo)
    }

}