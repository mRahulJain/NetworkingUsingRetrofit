package com.example.networkingassignretrofit

import retrofit2.Response
import retrofit2.http.GET

interface TodoAPI {

    @GET("todos")
    suspend fun getTodos(): Response<List<Todos>>

}