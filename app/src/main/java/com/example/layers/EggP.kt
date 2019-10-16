package com.example.layers

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.eggs.*
import java.lang.Exception


class EggP : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.eggs)


        btn_eggs.setOnClickListener {
            try {
                val intent = Intent(this,Submenu::class.java)
                startActivity(intent)
                finish()
        }
            catch (ex: Exception){
            ex.printStackTrace()}
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this,Submenu::class.java)
        startActivity(intent)

    }

}