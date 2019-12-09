package com.example.mvvm_login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_login.model.LogIn
import java.util.logging.Handler

/////////////////with simple state///////////////////////
// class ViewModelState(val loginOK:Boolean = false)

sealed class ViewModelState(val loginOK:Boolean = false, val error: String = "")

class ViewModelStateSuccess: ViewModelState(loginOK = true)
class ViewModelStateError(message: String): ViewModelState(loginOK = false,error = message)

class LogInViewModel : ViewModel() {

    private val USERNAME = "admin"
    private val PASSWORD = "pass"
    private val ERROR_MESSAGE = "User Name or password Wrong"

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

    fun getState() : LiveData<ViewModelState> = logIn

/////////////////with simple state///////////////////////
//    fun validateCredentials(user:String,password:String) {
//        var isItOK:Boolean?
//        if (user == USERNAME && password == PASSWORD) isItOK = true else isItOK = false
//        logIn.value = ViewModelState(isItOK)
//    }

    fun validateCredentials(user:String,password:String){
        var newLogIn = LogIn(user,password)

         if (newLogIn.user == USERNAME && newLogIn.password == PASSWORD){
             logIn.value = ViewModelStateSuccess()
         }else{
             logIn.value = ViewModelStateError(ERROR_MESSAGE)
         }
    }



}