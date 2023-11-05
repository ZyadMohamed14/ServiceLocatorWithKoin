package com.example.users.data.repo

import com.example.users.data.network.local.LocalDataBaseRepo
import com.example.users.data.network.remote.RemoteDataBaseRepo
import com.example.users.model.User
import retrofit2.Response

class DataSourceImpl(private val remoteDataBaseRepo: RemoteDataBaseRepo, private val localDataBaseRepo: LocalDataBaseRepo) :
    DataSourceReposotiory {
    override suspend fun getApiUsers(): Response<List<User>> = remoteDataBaseRepo.getApiUsers()



    override suspend fun getUsers(): List<User> =localDataBaseRepo.getUsers()



    override suspend fun deleteUser(user: User) =localDataBaseRepo.deleteUser(user)



    override suspend fun insertUserOrUpdate(user: User)  =localDataBaseRepo.insertUserOrUpdate(user)


}