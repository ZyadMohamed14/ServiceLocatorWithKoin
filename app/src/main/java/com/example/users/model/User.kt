package com.example.users.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.users.R

@Entity(tableName = "user_table")
data class User(@PrimaryKey(autoGenerate = true)var userId :Int=0,
                      var id:Int =0,
                      var name:String="zyad",
                      var title:String="empty Message",
                      var Imageid:Int= R.drawable.ic_launcher_foreground, var body:String="")



