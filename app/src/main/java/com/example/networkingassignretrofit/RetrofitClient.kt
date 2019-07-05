package com.example.networkingassignretrofit

import com.example.networkingassignretrofit.API.CommentAPI
import com.example.networkingassignretrofit.API.PostAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{

    val userApi = retrofit()
        .create(UserAPI::class.java)

    val todoApi = retrofit()
        .create(TodoAPI::class.java)

    val commentApi = retrofit()
        .create(CommentAPI::class.java)

    val postApi = retrofit()
        .create(PostAPI::class.java)

    private fun retrofit() = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}