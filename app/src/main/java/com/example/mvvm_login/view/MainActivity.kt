package com.example.mvvm_login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_login.R
import com.example.mvvm_login.viewmodel.LogInViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LogInViewModel
    private var user:String? = null
    private var pass:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user = userEditText.text.toString()
        pass = passEditText.text.toString()


        viewModel = ViewModelProviders.of(this).get(LogInViewModel::class.java)

        viewModel.validateCredentials(user!!,pass!!).observe(this, Observer { logIn ->
            if (logIn.logInOK){
                Toast.makeText(this,"New Activity Loading",Toast.LENGTH_LONG).show()
                logInButton.visibility = View.INVISIBLE
            } else {
                messageTextView.visibility = View.VISIBLE
            }
        })


    }
}
