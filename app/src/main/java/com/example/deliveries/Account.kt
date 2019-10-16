package com.example.deliveries

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_account.*

class Account : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        buttonA3.setOnClickListener {
            val intent = Intent(this,Deliveries::class.java)
            startActivity(intent)
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, Deliveries::class.java)
        startActivity(intent)

    }
}
