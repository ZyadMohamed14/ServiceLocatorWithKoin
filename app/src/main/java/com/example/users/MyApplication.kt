package com.example.users

import android.app.Application
import com.example.users.di.databaseModule
import com.example.users.di.reposotoryModule
import com.example.users.di.retrofitModule
import com.example.users.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(viewModelModule,reposotoryModule,databaseModule,retrofitModule))
        }
    }
}
