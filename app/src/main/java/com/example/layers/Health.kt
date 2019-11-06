package com.example.layers

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.health.*

class Health : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health)

        btn_health.setOnClickListener {
            //val intent = Intent(this, Submenu::class.java)
            //startActivity(intent)
            finish()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        //val intent = Intent(this, Submenu::class.java)
        //startActivity(intent)

    }

}