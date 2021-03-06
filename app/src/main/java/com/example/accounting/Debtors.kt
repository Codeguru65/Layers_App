package com.example.accounting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.Database.AppDb
import com.example.dailythings.AccAdapter
import com.example.dailythings.Data
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_debtors.*

class Debtors : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debtors)

        var acct = supportActionBar
        acct!!.title = "Debtors"
        acct.setDisplayHomeAsUpEnabled(true)

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB")
            .allowMainThreadQueries().build()

        var dataList = ArrayList<Data>()
        var total  = 0f
        db.clientTask().viewBal().forEach{
            var item = Data(it.nameClient , it.owing)
            total += it.owing
            dataList.add(item)

        }

        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        recyclerDebt.layoutManager = layout

        val adp = AccAdapter(this, dataList)
        recyclerDebt.adapter = adp

        debtTotal.text = total.toString()

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