package com.demirli.a54to_doapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.demirli.a54to_doapp.model.Todo

@Database(entities = arrayOf(Todo::class), version = 1)
abstract class TodoDb: RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {

        var INSTANCE: TodoDb? = null

        fun getInstance(context: Context): TodoDb{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDb::class.java,
                    "todo_db")
                    .build()
            }
            return INSTANCE as TodoDb
        }
    }

}