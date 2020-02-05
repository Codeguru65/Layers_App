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
import com.example.Database.Inventory_Entity
import com.example.dailythings.Adapter
import com.example.dailythings.Data
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


        if (db.inventoryDAO().viewFeed().isNullOrEmpty()) {
            var inventoryEntity1 = Inventory_Entity()
            var inventoryEntity2 = Inventory_Entity()
            var inventoryEntity3 = Inventory_Entity()
            inventoryEntity1.item ="10kg Bag"
            inventoryEntity1.qty=0f
            inventoryEntity2.item ="25kg Bag"
            inventoryEntity2.qty=0f
            inventoryEntity3.item ="50kg Bag"
            inventoryEntity3.qty=0f

            db.inventoryDAO().addtem(inventoryEntity1)
            db.inventoryDAO().addtem(inventoryEntity2)
            db.inventoryDAO().addtem(inventoryEntity3)

        }


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
