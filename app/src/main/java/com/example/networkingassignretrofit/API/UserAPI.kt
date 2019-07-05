package com.example.networkingassignretrofit

import retrofit2.Response
import retrofit2.http.GET

interface UserAPI {

    @GET("users")
    suspend fun getUsers(): Response<List<Users>>

}