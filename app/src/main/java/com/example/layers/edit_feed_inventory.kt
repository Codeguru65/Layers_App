package com.example.layers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Inventory_Entity
import kotlinx.android.synthetic.main.activity_edit_feed_inventory.*
import kotlinx.android.synthetic.main.feed_item.view.*

class edit_feed_inventory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_feed_inventory)

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").build()



       Thread{
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
       }.start()







        btnSaveItem.setOnClickListener {
            var total10kgBagsAdded = et_total_10kg.text.toString().toFloat()
            var total25kgBagsAdded  = et_total_25kg.text.toString().toFloat()
            var total50kgBagsAdded = et_total_50kg.text.toString().toFloat()


            Thread{
                var list = db.inventoryDAO().viewFeed()
               /* var total10kgBags = list[0].qty + total10kgBagsAdded
                var total25kgBags = list[1].qty + total25kgBagsAdded
                var total50kgBags = list[2].qty + total50kgBagsAdded

                var inventoryEntity1 = Inventory_Entity()
                inventoryEntity1.qty = total10kgBags
                var inventoryEntity2 = Inventory_Entity()
                inventoryEntity2.qty =total25kgBags
                var inventoryEntity3 = Inventory_Entity()
                inventoryEntity3.qty = total50kgBags

                db.inventoryDAO().addMoreFeed(inventoryEntity1)
                db.inventoryDAO().addMoreFeed(inventoryEntity2)
                db.inventoryDAO().addMoreFeed(inventoryEntity3)*/

               for(item in list){
                   Log.i("@override","id: ${item.id}")
                   Log.i("@override","item: ${item.item}")
                   Log.i("@override","qty: ${item.qty}")
               }



            }.start()





        }


        btnTest.setOnClickListener {
            Thread{
                db.inventoryDAO().viewFeed().forEach{
                    Log.i("@override","id : ${it.id}")
                    Log.i("@override","item: ${it.item}")
                    Log.i("@override","qty : ${it.qty}")

                }


            }.start()
        }

    }
}
