package com.example.production

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dailythings.Statistics
import com.example.layers.MainActivity
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_prod_sub.*

class ProdSub : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prod_sub)


        cvDaily.setOnClickListener {
            startActivity(Intent(this,Statistics::class.java))
            finish()
        }

        cvInv.setOnClickListener {
            startActivity(Intent(this,Inventory::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,MainActivity::class.java))
    }

}
