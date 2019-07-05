package com.example.networkingassignretrofit.ACTIVITY

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.networkingassignretrofit.ADAPTER.PostAdapter
import com.example.networkingassignretrofit.DATA_CLASS.Posts
import com.example.networkingassignretrofit.R
import com.example.networkingassignretrofit.RetrofitClient

import kotlinx.android.synthetic.main.activity_post.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PostActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        launch {
            val Posts = getPostRetrofit()

            rView4.layoutManager = LinearLayoutManager(this@PostActivity) as RecyclerView.LayoutManager?
            rView4.adapter = PostAdapter(Posts)

        }


    }

    suspend fun getPostRetrofit(): List<Posts> {
        val todoApi = RetrofitClient.postApi

        val response = todoApi.getPosts()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            emptyList()
        }
    }

}
