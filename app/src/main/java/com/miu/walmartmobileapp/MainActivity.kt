package com.miu.walmartmobileapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var user1=User("Donald","Nyagwande","nyagwandedonald@gmail.com","1234")
        var user2=User("Youcef","Cheikh","youcef.cheikh@miu.edu","0000")
        var user3=User("Mike","Muyembe","mike.muyembe@gmail.com","4444")
        var user4=User("Dennis","Nyoni","denis.nyoni@miu.edu","9874")
        var user5=User("Robel","Isaq","robel.isaq@miu.edu","4561")
        var uList= arrayListOf<User>(user1,user2,user3,user4,user5)

        forgotPassword.setOnClickListener {
            var pass:String=""
            var input=textEmail.text.toString()
            for (i:User in uList){
                if(i.userName.equals(input)){
                    pass=i.password
                    input=i.userName
                }
            }
            val intent=Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","youcef.cheikh@miu.edu",null))
            //intent.action=Intent.ACTION_SENDTO
            //intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, input)
            intent.putExtra(Intent.EXTRA_SUBJECT,"Reset password")

            intent.putExtra(Intent.EXTRA_TEXT,pass)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent,"SendEmail"))

        }



        signIn.setOnClickListener {
            val usernameString=textEmail.text.toString()
            val pass=textPassword.text.toString()

//            if(user1.userName.equals(usernameString)){
//                Toast.makeText(this,"Working",Toast.LENGTH_SHORT).show()
//            }else{
//                Toast.makeText(this,"Not working",Toast.LENGTH_SHORT).show()
//            }
            for(index:User in uList){
                if(index.userName.equals(usernameString)&& index.password.equals(pass)){
                    val signInIntent=Intent(this,ShoppingCart::class.java)
                    var stringEmail=index.userName.toString()
                    signInIntent.putExtra("email",stringEmail)
                    startActivity(signInIntent)
                    finish()
                    return@setOnClickListener
                }else{
                    Toast.makeText(this,"Username and PassWord are incorrect",Toast.LENGTH_SHORT).show()
                }
            }

        }
        var resultContracts=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result->
                if(result.resultCode== Activity.RESULT_OK) {
                    emailtxt.text = result.data?.data.toString()

                }else  emailtxt.text = "Failed to fetch result"

        }
        createNew.setOnClickListener {
            val myIntent= Intent(this,SecondActivity::class.java)
            resultContracts.launch(myIntent)
            finish()

        }
    }

//    fun forgotPassword(view: View) {
//        //Toast.makeText(this,"Reset Password",Toast.LENGTH_SHORT).show()
//        var getEmail=textEmail.text.toString()
//        var getEmailFromDb:User
//        for(index:User in uList){
//            if(index.userName.equals(getEmail))
//                getEmail=index.password
//        }
//        val intent=Intent()
//        intent.action=Intent.ACTION_SEND
//        intent.type="text/plain"
//        intent.putExtra(Intent.EXTRA_TEXT,getEmail)
//        startActivity(intent)
//    }

}