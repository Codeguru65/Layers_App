package com.example.deliveries

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layers.MainActivity
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_cash.*

class Cash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash)

        buttonS.setOnClickListener {
            val intent = Intent(this,Deliveries::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, Deliveries::class.java)
        startActivity(intent)
    }
}