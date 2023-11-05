package com.example.users.data.network.remote

import com.example.users.model.User
import retrofit2.Response

class RemoteDataBaseImpl(private val apiService: ApiService): RemoteDataBaseRepo {
    override suspend fun getApiUsers(): Response<List<User>> = apiService.getApiUsers()
}
//