package com.example.mvvm_login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm_login.R
import com.example.mvvm_login.viewmodel.LogInViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LogInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
