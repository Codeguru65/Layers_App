package com.example.Views

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.Database.AppDb
import com.example.dailythings.DataH
import com.example.dailythings.HistoryAdapter
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_daily__entries.*
import java.util.*
import kotlin.collections.ArrayList

class  Daily_Entries : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily__entries)

        var mtitle: TextView = findViewById(R.id.tool_title)
        mtitle.text = "Feed History"
        var back: Button = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }


        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB")
            .allowMainThreadQueries().build()

        var dataList = ArrayList<DataH>()

        db.feedTaskDAO().viewFeed().forEach{
            var item = DataH(it.feedType , it.quatity, it.date)

            dataList.add(item)

        }
        for (it in dataList){
            Log.i("@inventory"," description : ${it.description}")
        }

        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        recyclerHistory.layoutManager = layout

        val adp = HistoryAdapter(this, dataList)
        recyclerHistory.adapter = adp
            search.queryHint = "Enter Date"
            search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{

                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }

                override fun onQueryTextSubmit(query: String): Boolean {

                    var date = query


                    var dataList = ArrayList<DataH>()

                    db.feedTaskDAO().viewHistory(date).forEach {
                        var item = DataH(it.feedType, it.quatity, it.date)

                        dataList.add(item)

                    }
                    for (it in dataList) {
                        Log.i("@inventory", " description : ${it.description}")
                    }

                    val layout = LinearLayoutManager(this@Daily_Entries)
                    layout.orientation = LinearLayoutManager.VERTICAL
                    recyclerHistory.layoutManager = layout

                    val adp = HistoryAdapter(this@Daily_Entries, dataList)
                    recyclerHistory.adapter = adp

                    return false
                }
        })

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
