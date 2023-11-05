package com.example.users.data.network.remote


import com.example.users.model.User
import retrofit2.Response

interface RemoteDataBaseRepo {
    suspend fun getApiUsers():Response<List<User>>
}