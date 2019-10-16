package com.example.deliveries

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import com.example.layers.MainActivity
import com.example.layers.R
import com.example.layers.Submenu
import kotlinx.android.synthetic.main.activity_deliveries.*



class Deliveries : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deliveries)


        btnfin2.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }





}
