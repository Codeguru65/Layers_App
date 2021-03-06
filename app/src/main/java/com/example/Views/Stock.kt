package com.example.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import com.example.Database.AppDb
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_stock.*

class Stock : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock)


        var acct  = supportActionBar
        acct!!.title="Stock"
        acct.setDisplayHomeAsUpEnabled(true)

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()

        db.stockTask().viewStock().forEach {
            prodDescription.text = it.stockItem
            qtyStock.text = it.stockQty.toString()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
