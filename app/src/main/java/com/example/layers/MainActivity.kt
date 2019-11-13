package com.example.layers

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Window
import android.widget.Button
import com.example.deliveries.Account
import com.example.deliveries.Cash
import com.example.deliveries.PartPay
import com.example.production.Inventory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_daily_diary.setOnClickListener {
            showDiaryDialog()
        }

        /**
         * change the final method attached to the buttons i.e the finish() method
         */
        btn_deliveries.setOnClickListener {
            showDeliveries()
        }
        btn_production.setOnClickListener {
            showProductionDialog()

        }
    }

    private fun showDiaryDialog() {
        // create an alert builder
        val dialog = Dialog(this@MainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.daily_tasts_dialog)


        var btn_feed: Button = dialog.findViewById(R.id.btn_feed)
        var btn_eggs: Button = dialog.findViewById(R.id.btn_eggs)
        var btn_mortality: Button = dialog.findViewById(R.id.btn_motality)
        var btn_health : Button = dialog.findViewById(R.id.btn_health)
        var btn_water: Button = dialog.findViewById(R.id.btn_water)

        btn_feed.setOnClickListener {
            showBagSizeDialog()
            dialog.dismiss()
        }
        btn_eggs.setOnClickListener {
            startActivity(Intent(this,EggP::class.java))
        }
        btn_mortality.setOnClickListener {
            startActivity(Intent(this,Mort::class.java))
        }
        btn_health.setOnClickListener {
            startActivity(Intent(this, Health::class.java))
        }
        btn_water.setOnClickListener {
            startActivity(Intent(this,Water::class.java))
        }

        dialog.show()
    }


    private fun showProductionDialog(){
        // create an alert builder
        val dialog = Dialog(this@MainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.production_dialogue)

        //button handlers here
        var btnInventory : Button = dialog.findViewById(R.id.btn_inventory)
        var btnReports   : Button = dialog.findViewById(R.id.btn_daily_entries)
        var btnDailyEntries : Button = dialog.findViewById(R.id.btn_reports)




        btnInventory.setOnClickListener {
            showInventoryOptions()
            dialog.dismiss()
        }

        btnDailyEntries.setOnClickListener {
            showInventoryOptions()
            dialog.dismiss()
        }

        btnReports.setOnClickListener {
            showInventoryOptions()
            dialog.dismiss()
        }
        dialog.show()

    }

    private fun showInventoryOptions() {
        val dialog = Dialog(this@MainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.inventory_options)


        var btnViewInventorry : Button = dialog.findViewById(R.id.btn_view_inventory)
        var btnEditInventory : Button = dialog.findViewById(R.id.btn_edit_inventory)
        var btnAddItem : Button = dialog.findViewById(R.id.btn_add_item)

       btnEditInventory.setOnClickListener {
           startActivity(Intent(this,edit_feed_inventory::class.java))
           dialog.dismiss()
       }

        btnViewInventorry.setOnClickListener {
            startActivity(Intent(this,Inventory::class.java))

           // Toast.makeText(this, "the button is working ", Toast.LENGTH_SHORT).show()
        }

        btnAddItem.setOnClickListener {

        }

        dialog.show()
    }


    //this mothod is display the bag size dialogue
    private fun showBagSizeDialog() {
        // create an alert builder
        val dialog = Dialog(this@MainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.bag_size_dialog)



        var btn10Kg: Button = dialog.findViewById(R.id.btn_10kg_bag)
        var btn25kg: Button = dialog.findViewById(R.id.btn_25kg_bag)
        var btn50kg: Button = dialog.findViewById(R.id.btn_50kg_bag)


        //onclick listener for showing the feed activity loaded with relevent information
        btn10Kg.setOnClickListener {
            var intent = Intent(this@MainActivity, DailyFeedActivity::class.java)
            val type : Int = 10
            intent.putExtra("BAG_SIZE", type)
            startActivity(intent)

            dialog.dismiss()
        }

        btn25kg.setOnClickListener {
            var intent = Intent(this@MainActivity, DailyFeedActivity::class.java)
            val type : Int = 25
            intent.putExtra("BAG_SIZE", type)
            startActivity(intent)

            dialog.dismiss()
        }

        btn50kg.setOnClickListener {
            var intent = Intent(this@MainActivity, DailyFeedActivity::class.java)
            val type : Int = 50
            intent.putExtra("BAG_SIZE", type)
            startActivity(intent)

            dialog.dismiss()
        }




        dialog.show()
    }


    private fun showDeliveries(){
        // create an alert builder
        val dialog = Dialog(this@MainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.deliveries_dialog)


        var btn_cash: Button = dialog.findViewById(R.id.btn_cash)
        var btn_acc: Button = dialog.findViewById(R.id.btn_acc)
        var btn_part: Button = dialog.findViewById(R.id.btn_partP)

        btn_cash.setOnClickListener {
            startActivity(Intent(this, Cash::class.java))
            finish()
            dialog.dismiss()
        }
        btn_acc.setOnClickListener {
            startActivity(Intent(this,Account::class.java))
            dialog.dismiss()
            finish()
        }
        btn_part.setOnClickListener {
            startActivity(Intent(this,PartPay::class.java))
            dialog.dismiss()
            finish()
        }

        dialog.show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
//        val intent = Intent(this, LoginActivity::class.java)
//        startActivity(intent)

    }
}
