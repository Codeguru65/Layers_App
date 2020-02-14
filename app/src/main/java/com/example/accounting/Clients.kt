package com.example.accounting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Client_Entity
import com.example.dailythings.ClientAdapter
import com.example.dailythings.DataC
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_clients.*


class Clients : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clients)


        var mtitle: TextView = findViewById(R.id.tool_title)
        mtitle.text = "Clients"
        var back: Button = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()

        var datalIst = ArrayList<DataC>()

        db.clientTask().veiwClient().forEach {
            var item = DataC(it.nameClient, it.clientType, it.phone)
            datalIst.add(item)
        }

        var layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        recyclerClients.layoutManager = layout

        val adp = ClientAdapter(this, datalIst)
        recyclerClients.adapter = adp


        newClient.setOnClickListener {
            startActivity(Intent(this, NewClient::class.java))
            finish()
        }

    }
}
