package com.example.networkingassignretrofit

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_todo.*
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class TodoActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        launch {
            val Todos = getTodoRetrofit()

            rView1.layoutManager = LinearLayoutManager(this@TodoActivity) as RecyclerView.LayoutManager?
            rView1.adapter = TodoAdapter(Todos)

        }

    }

    suspend fun getTodoRetrofit(): List<Todos> {
        val todoApi = RetrofitClient.todoApi

        val response = todoApi.getTodos()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            emptyList()
        }
    }



}
