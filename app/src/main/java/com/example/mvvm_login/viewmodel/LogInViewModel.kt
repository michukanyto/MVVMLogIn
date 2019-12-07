package com.example.mvvm_login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_login.model.LogIn

class LogInViewModel : ViewModel() {

    private val USERNAME = "admin"
    private val PASSWORD = "pass"

    private val logIn = MutableLiveData<LogIn>()

    fun validateCredentials(user:String,password:String): LiveData<LogIn> {
        var isItOK:Boolean = false
        isItOK = user == USERNAME && password == PASSWORD
        logIn.value = LogIn(user,password,isItOK)
        return logIn
    }
}