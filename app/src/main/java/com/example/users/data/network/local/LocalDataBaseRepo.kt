package com.example.users.data.network.local

import com.example.users.model.User

interface LocalDataBaseRepo {
    suspend  fun getUsers():List<User>
    suspend fun deleteUser(user: User)
    suspend fun insertUserOrUpdate(user: User)
}