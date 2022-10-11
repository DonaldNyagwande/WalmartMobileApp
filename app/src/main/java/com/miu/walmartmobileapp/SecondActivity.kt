package com.miu.walmartmobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        intent
        var firstName= inputName.text.toString()
        var lastName=inputLastName.text.toString()
        var userName=inputEmail.text.toString()
        var pass=inputPassword.text.toString()
        var userNew=User(firstName,lastName,userName,pass)

        createNewAccount.setOnClickListener {

        }
    }



}