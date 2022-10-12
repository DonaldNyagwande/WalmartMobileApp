package com.miu.walmartmobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_cart.*

class ShoppingCart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)
        val rIntent=intent
        val receiveEmail=rIntent.getStringExtra("email")
        displayEmail.text=receiveEmail

    }

    fun displayToast(view: View) {
        var selectImg=view.id
        when(selectImg){
            R.id.imageView2->{
                Toast.makeText(this,"You've selected the Electronics ",Toast.LENGTH_SHORT).show()
            }
            R.id.imageView3->{
                Toast.makeText(this,"You've selected the Clothing",Toast.LENGTH_SHORT).show()
            }
            R.id.imageView6->{
                Toast.makeText(this,"You've selected the Food",Toast.LENGTH_SHORT).show()
            }
            R.id.imageView4->{
                Toast.makeText(this,"You've selected the Beauty",Toast.LENGTH_SHORT).show()
            }
        }
    }
}