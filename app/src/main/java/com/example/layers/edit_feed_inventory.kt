package com.example.layers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Inventory_Entity
import com.example.production.Inventory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_edit_feed_inventory.*

class edit_feed_inventory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_feed_inventory)

        var mtitle: TextView = findViewById(R.id.tool_title)
        mtitle.text = "Add new Item"
        var back : Button = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()

        var list = db.inventoryDAO().viewFeed()


          if (db.inventoryDAO().viewFeed().isNullOrEmpty()) {
              var inventoryEntity1 = Inventory_Entity()
              var inventoryEntity2 = Inventory_Entity()
              var inventoryEntity3 = Inventory_Entity()
              inventoryEntity1.item ="10_kg_bag"
              inventoryEntity1.qty=0f
              inventoryEntity2.item ="25_kg_bag"
              inventoryEntity2.qty=0f
              inventoryEntity3.item ="50_kg_bag"
              inventoryEntity3.qty=0f

              db.inventoryDAO().addtem(inventoryEntity1)
              db.inventoryDAO().addtem(inventoryEntity2)
              db.inventoryDAO().addtem(inventoryEntity3)

          }

        btnSaveItem.setOnClickListener {




            if(et_total_10kg.text.toString().isNotEmpty()){
                var required = et_total_10kg.text.toString().toFloat() * 10.toFloat()
                var inventoryEntity1 = Inventory_Entity()
                inventoryEntity1.id = 1
                inventoryEntity1.item = "10_kg_bag"
                inventoryEntity1.qty = required+ list[0].qty

                db.inventoryDAO().addMoreFeed(inventoryEntity1)

            }

            if(et_total_25kg.text.toString().isNotEmpty()){
                var required = et_total_25kg.text.toString().toFloat() * 25.toFloat()
                var inventoryEntity1 = Inventory_Entity()
                inventoryEntity1.id = 2
                inventoryEntity1.item =list[1].item
                inventoryEntity1.qty = required + list[1].qty

                db.inventoryDAO().addMoreFeed(inventoryEntity1)

            }

            if(et_total_50kg.text.toString().isNotEmpty()){
                var required =  et_total_50kg.text.toString().toFloat() * 50.toFloat()
                var inventoryEntity1 = Inventory_Entity()
                inventoryEntity1.id = 3
                inventoryEntity1.item =list[2].item
                inventoryEntity1.qty =  required + list[2].qty

                db.inventoryDAO().addMoreFeed(inventoryEntity1)

            }

            Toast.makeText(this,"RECORDS UPDATED", Toast.LENGTH_SHORT)
            et_total_10kg.text.clear()
            et_total_25kg.text.clear()
            et_total_50kg.text.clear()

            /*db.inventoryDAO().viewFeed().forEach{
                Log.i("@override","id: ${it.id}")
                Log.i("@override","item: ${it.item}")
                Log.i("@override","qty: ${it.qty}")
            }*/

            list = db.inventoryDAO().viewFeed()

            for(it in list){

                Log.i("@override","id: ${it.id}")
                Log.i("@override","item: ${it.item}")
                Log.i("@override","qty: ${it.qty}")
            }

            Toast.makeText(this,"RECORDS UPDATED", Toast.LENGTH_SHORT).show()



        }


        btnTest.setOnClickListener {
            db.inventoryDAO().viewFeed().forEach(){
                Log.i("@override","id: ${it.id}")
                Log.i("@override","item: ${it.item}")
                Log.i("@override","qty: ${it.qty}")
            }
        }



        val bottomNavigation: BottomNavigationView = findViewById(R.id.btm_nav)
        bottomNavigation.setOnNavigationItemSelectedListener(navListener)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                finish()
                startActivity(Intent(this,MainActivity::class.java))
                Toast.makeText(this,"home pressed",Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true


            }
            R.id.home1-> {
                finish()
                startActivity(Intent(this, Inventory::class.java))
                Toast.makeText(this,"home pressed",Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true


            }
            R.id.home2-> {
                finish()
                startActivity(Intent(this, MainActivity::class.java))
                Toast.makeText(this,"home pressed",Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true

            }
            R.id.home3-> {
                finish()
                startActivity(Intent(this, Inventory::class.java))
                Toast.makeText(this,"home pressed",Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true

            }
        }
        false
    }

}
