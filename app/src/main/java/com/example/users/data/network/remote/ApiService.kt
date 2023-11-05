package com.example.users.data.network.remote

import com.example.users.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getApiUsers():Response<List<User>>
}