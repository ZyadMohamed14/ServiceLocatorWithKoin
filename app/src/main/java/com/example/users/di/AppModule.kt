package com.example.users.di

import androidx.room.Room
import com.example.users.data.repo.DataSourceImpl
import com.example.users.data.repo.DataSourceReposotiory
import com.example.users.data.network.local.LocalDataBaseRepo
import com.example.users.data.network.local.LocalDataBaseRepoImpl
import com.example.users.data.network.local.UserDataBase
import com.example.users.data.network.remote.ApiService
import com.example.users.data.network.remote.RemoteDataBaseImpl
import com.example.users.data.network.remote.RemoteDataBaseRepo
import com.example.users.ui.userdatascreen.UserViewModel
import com.example.users.ui.userdatascreen.UserViewModelFactory
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule= module {
   // single { UserViewModelFactory(get()) }
    viewModel { UserViewModel(dataSourceReposotiory = get())}}
val reposotoryModule= module {
    single <RemoteDataBaseRepo>{ RemoteDataBaseImpl(apiService = get()) }
    single <LocalDataBaseRepo>{LocalDataBaseRepoImpl(get()) }
    single { UserDataBase }
    single <DataSourceReposotiory>{ DataSourceImpl(remoteDataBaseRepo = get(), localDataBaseRepo = get()) }
}
val retrofitModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/") // Replace with your API base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single {
        get<Retrofit>().create(ApiService::class.java)
    }
}
val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            UserDataBase::class.java,
            "my_database"
        ).build()
    }
    single(qualifier = named("userDao")) {
        get<UserDataBase>().userDao()
    }
}