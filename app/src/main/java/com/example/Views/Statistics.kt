package com.example.dailythings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.layers.R
import com.example.production.ProdSub
import kotlinx.android.synthetic.main.activity_statistics.*

class Statistics : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)



        btn_details.setOnClickListener {
            btn_details.isVisible = false
            btn_hDetails.isVisible = true
            ltext.isVisible = true

//            dbnew.dailyTaskDao().readAll()
//            ds5.setText(task2.feed_type5kg)
//            ds20.setText(task2.feed_type20kg)
//            ds50.setText(task2.feed_type50kg)
//             var total = ((task2.feed_type50kg * 50)+(task2.feed_type20kg * 20)+(task2.feed_type5kg*5))
//
        }


        btn_hDetails.setOnClickListener {
            btn_hDetails.isVisible = false
            ltext.isVisible = false
            btn_details.isVisible = true
        }



    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,ProdSub::class.java))
    }

}
