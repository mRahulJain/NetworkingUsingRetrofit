package com.example.networkingassignretrofit.ACTIVITY

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.networkingassignretrofit.ADAPTER.CommentAdapter
import com.example.networkingassignretrofit.DATA_CLASS.Comments
import com.example.networkingassignretrofit.R
import com.example.networkingassignretrofit.RetrofitClient

import kotlinx.android.synthetic.main.activity_comment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CommentActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        launch {
            val comments = getCommentRetrofit()

            rView3.layoutManager = LinearLayoutManager(this@CommentActivity) as RecyclerView.LayoutManager?
            rView3.adapter = CommentAdapter(comments)
        }
    }

    suspend fun getCommentRetrofit(): List<Comments> {
        val todoApi = RetrofitClient.commentApi

        val response = todoApi.getComments()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            emptyList()
        }
    }

}
