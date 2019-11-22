package com.example.layers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Inventory_Entity
import com.example.Database.Stock_Entity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()

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
        if (db.stockTask().viewStock().isNullOrEmpty()){
            var stock = Stock_Entity()
            stock.stockItem = "Eggs"
            stock.stockQty = 0

            db.stockTask().addEggs(stock)
        }

    }
}
