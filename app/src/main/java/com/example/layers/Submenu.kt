package com.example.layers

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_submenu.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Submenu : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submenu)

//        val date = LocalDate.now()
//
//        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
//        val fDate = date.format(formatter)
//
//        date1.setText(fDate)

        btnfin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        cvFeed.setOnClickListener {
            val intent = Intent(this, DailyDiaryActivity::class.java)
            startActivity(intent)
            finish()
        }
        cvEgg.setOnClickListener {
            val intent = Intent(this, EggP::class.java)
            startActivity(intent)
            finish()
        }
        cvHealth.setOnClickListener {
            val intent = Intent(this, Health::class.java)
            startActivity(intent)
            finish()
        }
        cvMort.setOnClickListener {
            val intent = Intent(this, Mort::class.java)
            startActivity(intent)
            finish()
        }
        cvWater.setOnClickListener {
            val intent = Intent(this, Water::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)


    }
}
