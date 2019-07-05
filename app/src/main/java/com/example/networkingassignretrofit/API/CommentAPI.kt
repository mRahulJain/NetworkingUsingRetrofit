package com.example.networkingassignretrofit.API

import com.example.networkingassignretrofit.DATA_CLASS.Comments
import com.example.networkingassignretrofit.Todos
import retrofit2.Response
import retrofit2.http.GET

interface CommentAPI {

    @GET("comments")
    suspend fun getComments(): Response<List<Comments>>

}