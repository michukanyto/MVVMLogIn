package com.example.mvvm_login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_login.model.LogIn

class LogInViewModel : ViewModel() {

    private val logIn = MutableLiveData<LogIn>()

    fun validateCredentials(user:String,password:String): LiveData<LogIn> {
        return logIn

    }
}