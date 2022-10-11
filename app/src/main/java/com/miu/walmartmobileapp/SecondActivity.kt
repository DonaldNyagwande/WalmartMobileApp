package com.miu.walmartmobileapp

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



        createNewAccount.setOnClickListener {
            var resIntent=intent
            var firstName= inputName.text.toString()
            var lastName=inputLastName.text.toString()
            var userName=inputEmail.text.toString()
            var pass=inputPassword.text.toString()
            var userNew=User(firstName,lastName,userName,pass)
            Toast.makeText(this,"Account created successfully",Toast.LENGTH_SHORT).show()

            resIntent.putExtra("user",userNew)
            setResult(Activity.RESULT_OK,resIntent)

            finish()


        }

    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }



}
