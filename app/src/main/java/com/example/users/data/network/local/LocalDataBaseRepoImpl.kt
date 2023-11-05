package com.example.users.data.network.local

import com.example.users.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataBaseRepoImpl(private val userDataBase: UserDataBase) : LocalDataBaseRepo {
    override suspend fun getUsers(): List<User> = withContext(Dispatchers.IO){userDataBase.userDao().getUsers()}
    override suspend fun deleteUser(user: User) = withContext(Dispatchers.IO){userDataBase.userDao().deleteUser(user)}
    override suspend fun insertUserOrUpdate(user: User) = withContext(Dispatchers.IO){userDataBase.userDao().insertUserOrUpdate(user)}
}