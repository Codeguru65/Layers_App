package com.example.deliveries

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import com.example.layers.MainActivity
import com.example.layers.R
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

        cvCash.setOnClickListener {
            val intent = Intent(this,Cash::class.java)
            startActivity(intent)
            finish()
        }
        cvAcc.setOnClickListener {
            val intent = Intent(this, Account::class.java)
            startActivity(intent)
            finish()
        }
        cvPay.setOnClickListener {
            val intent = Intent(this,PartPay::class.java)
            startActivity(intent)
            finish()
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }





}
