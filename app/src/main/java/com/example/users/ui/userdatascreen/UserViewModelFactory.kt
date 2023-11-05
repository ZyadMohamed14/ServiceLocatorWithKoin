package com.example.users.ui.userdatascreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.users.data.repo.DataSourceReposotiory

class UserViewModelFactory(private val dataSourceReposotiory: DataSourceReposotiory) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(dataSourceReposotiory) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
