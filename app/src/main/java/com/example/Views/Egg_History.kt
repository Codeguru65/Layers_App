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
import com.example.dailythings.EggAdapter
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_egg__history.*
import java.util.*
import kotlin.collections.ArrayList

class Egg_History : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_egg__history)

        var mtitle: TextView = findViewById(R.id.tool_title)
        mtitle.text = "Egg Picking History"
        var back: Button = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }


        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB")
            .allowMainThreadQueries().build()

        var dataList = ArrayList<DataH>()

        db.eggTaskDAO().viewEgg().forEach{
            var item = DataH(it.picked.toString() , it.broken.toFloat(), it.date)

            dataList.add(item)

        }
        for (it in dataList){
            Log.i("@inventory"," description : ${it.description}")
        }

        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        recyclerEggHistory.layoutManager = layout

        val adp = EggAdapter(this, dataList)
        recyclerEggHistory.adapter = adp
        search.queryHint = "Search Date"
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {

                var date = query

                var dataList = ArrayList<DataH>()

                db.eggTaskDAO().viewEggHistory(date).forEach{
                    var item = DataH(it.picked.toString() , it.broken.toFloat(), it.date)

                    dataList.add(item)

                }
                for (it in dataList){
                    Log.i("@inventory"," description : ${it.description}")
                }

                val layout = LinearLayoutManager(this@Egg_History)
                layout.orientation = LinearLayoutManager.VERTICAL
                recyclerEggHistory.layoutManager = layout

                val adp = EggAdapter(this@Egg_History, dataList)
                recyclerEggHistory.adapter = adp

                return false
            }

        })

        }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
