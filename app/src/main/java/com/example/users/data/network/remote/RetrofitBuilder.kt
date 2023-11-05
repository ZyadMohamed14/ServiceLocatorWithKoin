package com.example.users.data.network.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val getApiService = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/") // Replace with your API base URL
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(ApiService::class.java)
}