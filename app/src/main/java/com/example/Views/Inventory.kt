package com.example.production

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layers.R
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.Database.AppDb
import com.example.dailythings.Adapter
import com.example.dailythings.Data
import com.example.dailythings.Supplier
import kotlinx.android.synthetic.main.activity_inventory.*

class Inventory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)

        var mtitle: TextView = findViewById(R.id.tool_title)
        mtitle.text = "Inventory"
        var back : Button = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }

       var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()


       var dataList = ArrayList<Data>()

       db.inventoryDAO().viewFeed().forEach{
           var item = Data(it.item , it.qty)
           dataList.add(item)

       }


        for (it in dataList){
            Log.i("@inventory"," description : ${it.description}")
        }






        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        recyclerView2.layoutManager = layout

        val  adp = Adapter(this, dataList)
        recyclerView2.adapter = adp
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
