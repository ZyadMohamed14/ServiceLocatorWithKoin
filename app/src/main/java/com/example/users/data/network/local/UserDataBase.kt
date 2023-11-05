package com.example.users.data.network.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.users.data.network.local.dao.UserDao
import com.example.users.model.User
import kotlin.concurrent.Volatile

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase:RoomDatabase() {
abstract fun userDao(): UserDao
    companion object {
        @Volatile
        private var instance : UserDataBase?=null
        fun getInstance(context: Context): UserDataBase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                    "my_database"
                ).build().also { instance = it }
            }
        }
    }
}
/*

 */