package com.example.mvvm_login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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


        viewModel = ViewModelProviders.of(this).get(LogInViewModel::class.java)

        logInButton.setOnClickListener {
            user = userEditText.text.toString()
            pass = passEditText.text.toString()

            viewModel.validateCredentials(user!!,pass!!)

//            viewModel.logIn.observe(this, Observer { logIn ->
//                Log.i("-------------",logIn.loginOK.toString())
//                if (logIn.loginOK){
//                    Toast.makeText(this,"New Activity Loading",Toast.LENGTH_LONG).show()
//                    logInButton.visibility = View.INVISIBLE
//                    messageTextView.visibility = View.INVISIBLE
//                } else {
//                    messageTextView.visibility = View.VISIBLE
//                }
//            })

            viewModel.getState().observe(this, Observer { logIn ->
                Log.i("-------------",logIn.loginOK.toString())
                when(logIn.loginOK){
                    true ->  {
                        Toast.makeText(this,"New Activity Loading",Toast.LENGTH_LONG).show()
                        logInButton.isEnabled = false
                        messageTextView.visibility = View.INVISIBLE
//                        Thread.sleep(2000)
//                        logInButton.isEnabled = true
                    }

                    false -> {
                        messageTextView.visibility = View.VISIBLE
                        messageTextView.text = logIn.error
                    }

                }
            })
        }

    }
}
