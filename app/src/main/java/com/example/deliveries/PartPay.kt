package com.example.deliveries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_part_pay.*
import android.content.Intent

class PartPay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part_pay)


        buttonP3.setOnClickListener {
            val intent = Intent(this,Deliveries::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this,Deliveries::class.java)
        startActivity(intent)

    }
}
