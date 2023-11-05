package com.example.users.ui.userdatascreen


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.users.data.repo.DataSourceImpl
import com.example.users.data.repo.DataSourceReposotiory
import com.example.users.model.User

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel(private val dataSourceReposotiory: DataSourceReposotiory):ViewModel(){

    private var mLocalUserLiveData = MutableLiveData<List<User>>()
    val LocaluserLivedata:LiveData<List<User>> get() = mLocalUserLiveData

    private var mRemoteUserLiveData = MutableLiveData<List<User>>()
    val remoteUserLivedata:LiveData<List<User>> get() = mRemoteUserLiveData

    fun getUsers(){
        viewModelScope.launch {
            mLocalUserLiveData.postValue(dataSourceReposotiory.getUsers())
        }

    }
    fun addUsers(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            dataSourceReposotiory.insertUserOrUpdate(user)
        }

    }
    fun deleteUsers(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            dataSourceReposotiory.deleteUser(user)
        }

    }
    fun getUserFromRemote(){
        viewModelScope.launch {
            val result = dataSourceReposotiory.getApiUsers()
            if(result.isSuccessful){
                if(result.body()!= null){
                    mRemoteUserLiveData.postValue(result.body())
                }
            }
            else{
                // Handel Errors result.getmessage
            }
        }

    }


}