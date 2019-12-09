package com.example.mvvm_login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_login.model.LogIn

/////////////////with simple state///////////////////////
 class ViewModelState(val loginOK:Boolean = false)

//sealed class ViewModelState(val loginOK:Boolean = false)

//class ViewModelStateLoading: ViewModelState(loginOK = false)
//class ViewModelStateSucces: ViewModelState(loginOK = true)
//class ViewModelStateError: ViewModelState(loginOK = false)

class LogInViewModel : ViewModel() {

    private val USERNAME = "admin"
    private val PASSWORD = "pass"

//    ////////without states///////////////
//    private val logIn = MutableLiveData<LogIn>()
//
//    fun validateCredentials(user:String,password:String): LiveData<LogIn> {
//        var isItOK:Boolean?
//         if (user == USERNAME && password == PASSWORD) isItOK = true else isItOK = false
//        logIn.value = LogIn(user,password,isItOK)
//        return logIn
//
//    }

    val logIn = MutableLiveData<ViewModelState>()

/////////////////with simple state///////////////////////
    fun validateCredentials(user:String,password:String) {
        var isItOK:Boolean?
        if (user == USERNAME && password == PASSWORD) isItOK = true else isItOK = false
        logIn.value = ViewModelState(isItOK)
    }

//    fun validateCredentials(user:String,password:String): LiveData<ViewModelState> {
//        var isItOK:Boolean?
//         if (user == USERNAME && password == PASSWORD) isItOK = true else isItOK = false
//        logIn.value = ViewModelState(isItOK)
//        return logIn
//
//    }

}