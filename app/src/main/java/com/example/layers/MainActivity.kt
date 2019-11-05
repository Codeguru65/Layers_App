package com.example.layers

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.deliveries.Deliveries
import com.example.production.Inventory
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_daily_diary.setOnClickListener {
            val intent = Intent(this,Submenu::class.java)
            startActivity(intent)
            finish()
        }

        /**
         * change the final method attached to the buttons i.e the finish() method
         */
        btn_deliveries.setOnClickListener {
            val intent = Intent(this, Deliveries::class.java)
            startActivity(intent)
            finish()
        }
        btn_production.setOnClickListener {
            startActivity(Intent(this,Inventory::class.java))
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onBackPressed() {
        super.onBackPressed()
//        val intent = Intent(this, LoginActivity::class.java)
//        startActivity(intent)
        finishAffinity()
    }
}
