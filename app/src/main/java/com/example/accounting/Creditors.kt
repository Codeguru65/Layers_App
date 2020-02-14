package com.example.accounting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.Database.AppDb
import com.example.dailythings.CredAdapter
import com.example.dailythings.Data
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_creditors.*

class Creditors : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creditors)

        var mtitle: TextView = findViewById(R.id.tool_title)
        mtitle.text = "Creditors"
        var back: Button = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB")
            .allowMainThreadQueries().build()

        var dataList = ArrayList<Data>()
        var total  = 0f
        db.credTask().viewCreditors().forEach{
            var item = Data(it.credNames , it.owingCred)
            total += it.owingCred
            dataList.add(item)

        }

        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        recyclerCred.layoutManager = layout

        val adp = CredAdapter(this, dataList)
        recyclerCred.adapter = adp

        credTotal.text = total.toString()

    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()

    }
}
