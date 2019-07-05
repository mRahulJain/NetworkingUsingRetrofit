package com.example.networkingassignretrofit.API

import com.example.networkingassignretrofit.DATA_CLASS.Posts
import com.example.networkingassignretrofit.Todos
import retrofit2.Response
import retrofit2.http.GET

interface PostAPI {

    @GET("posts")
    suspend fun getPosts(): Response<List<Posts>>

}