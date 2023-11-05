package com.example.users.data.network.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.users.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertUserOrUpdate(user: User)

    @Delete
    suspend  fun deleteUser(user: User)
    @Query("select * from user_table")
    suspend  fun getUsers():List<User>
}