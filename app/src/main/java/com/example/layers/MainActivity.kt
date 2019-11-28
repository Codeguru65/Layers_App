package com.example.layers

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Window
import android.widget.Button
import android.content.SharedPreferences
import android.widget.Toast
import com.example.Notifications.NotificationUtils
import com.example.Views.Daily_Entries
import com.example.Views.Egg_History
import com.example.Views.Stock
import com.example.deliveries.Account
import com.example.deliveries.Cash
import com.example.deliveries.PartPay
import com.example.production.Inventory
import java.util.*
import com.example.layers.LoginActivity.*


class MainActivity : AppCompatActivity() {

    private val mNotificationTime = Calendar.getInstance().timeInMillis + 86400000 //Set after 24hrs from the current time.
    private var mNotified = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_daily_diary.setOnClickListener {
            showDiaryDialog()
        }
        if (!mNotified) {
            NotificationUtils().setNotification(mNotificationTime, this@MainActivity)
        }

        btn_deliveries.setOnClickListener {
            startActivity(Intent(this,PartPay::class.java))

        }
        btn_production.setOnClickListener {
            showProductionDialog()

        }

        logout.setOnClickListener{
            showOptions()

        }

    }
    //this method is display the daily tasks dialogue
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
            startActivity(Intent(this, Water::class.java))

        }

        dialog.show()
    }

    //this method is display the production dialogue
    private fun showProductionDialog(){
        // create an alert builder
        val dialog = Dialog(this@MainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.production_dialogue)

        //button handlers here
        var btnInventory : Button = dialog.findViewById(R.id.btn_inventory)
        var btnReports   : Button = dialog.findViewById(R.id.btn_reports)
        var btnDailyEntries : Button = dialog.findViewById(R.id.btn_daily_entries)


        btnInventory.setOnClickListener {
            showInventoryOptions()
            dialog.dismiss()
        }

        btnDailyEntries.setOnClickListener {
            showDailyEntriesOptions()
            dialog.dismiss()
        }

        btnReports.setOnClickListener {
        }
        dialog.show()

    }

    //this method is display the inventory dialogue
    private fun showInventoryOptions() {
        val dialog = Dialog(this@MainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.inventory_options)


        var btnViewInventorry : Button = dialog.findViewById(R.id.btn_view_inventory)
        var btnEditInventory : Button = dialog.findViewById(R.id.btn_edit_inventory)
        var btnViewStock  : Button  =dialog.findViewById(R.id.btn_view_stock)
//        var btnAddItem : Button = dialog.findViewById(R.id.btn_add_item)

       btnEditInventory.setOnClickListener {
           startActivity(Intent(this,edit_feed_inventory::class.java))

       }

        btnViewInventorry.setOnClickListener {
            startActivity(Intent(this,Inventory::class.java))

           // Toast.makeText(this, "the button is working ", Toast.LENGTH_SHORT).show()
        }

        btnViewStock.setOnClickListener {
            startActivity(Intent(this,Stock::class.java))
        }

//        btnAddItem.setOnClickListener {
//
//        }

        dialog.show()
    }

    //this method is display the daily entries dialogue
    private fun showDailyEntriesOptions() {
        // create an alert builder
        val dialog = Dialog(this@MainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.daily_entries_dialog)


        var btn_feed: Button = dialog.findViewById(R.id.btn_EFeed)
        var btn_eggs: Button = dialog.findViewById(R.id.btn_EEgg)


        btn_feed.setOnClickListener {
            startActivity(Intent(this,Daily_Entries::class.java))
        }
        btn_eggs.setOnClickListener {
            startActivity(Intent(this, Egg_History::class.java))

        }
        dialog.show()
    }

    //this method is display the bag size dialogue
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


        }

        btn25kg.setOnClickListener {
            var intent = Intent(this@MainActivity, DailyFeedActivity::class.java)
            val type : Int = 25
            intent.putExtra("BAG_SIZE", type)
            startActivity(intent)


        }

        btn50kg.setOnClickListener {
            var intent = Intent(this@MainActivity, DailyFeedActivity::class.java)
            val type : Int = 50
            intent.putExtra("BAG_SIZE", type)
            startActivity(intent)


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
        }
        btn_acc.setOnClickListener {
            startActivity(Intent(this,Account::class.java))
        }
        btn_part.setOnClickListener {
            startActivity(Intent(this,PartPay::class.java))
        }

        dialog.show()
    }

    private fun showOptions(){
        var sp = getSharedPreferences("logStatus", MODE_PRIVATE)
        val dialog = Dialog(this@MainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.user_dialog)

        var user : Button = dialog.findViewById(R.id.btn_logout)
        user.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            sp.edit().putBoolean("logged",false).apply()
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
