package com.example.users.data.repo

import com.example.users.data.network.local.LocalDataBaseRepo
import com.example.users.data.network.remote.RemoteDataBaseRepo

interface DataSourceReposotiory: RemoteDataBaseRepo, LocalDataBaseRepo {
}