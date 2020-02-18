package com.example.layers

import android.app.ActionBar
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.DFU_Entity
import com.example.Database.Inventory_Entity

import kotlinx.android.synthetic.main.activity_daily_feed.*
import kotlinx.android.synthetic.main.activity_daily_feed.tvDate
import kotlinx.android.synthetic.main.eggs.*
import kotlinx.android.synthetic.main.tool_bar.*
import java.util.*


class DailyFeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_feed)

        var acct = supportActionBar
        acct!!.title = " ]"
        var level10kg :Float? = null
        var level25kg :Float? = null
        var level50kg :Float? = null

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()
        var list = db.inventoryDAO().viewFeed()

        val bundle : Bundle? = intent.extras
        val bagSize : Int = bundle!!.getInt("BAG_SIZE")
        Log.i("@bagsize","type : ${bagSize.toString()+"_kg_bag"}")

        if (bagSize.toString().equals("10")){
            acct.title = "Feed 10kg"
        }
        if (bagSize.toString().equals("25")) {
            acct.title = "Feed 25kg"
        }
        if(bagSize.toString().equals("50")){
            acct.title = "Feed 50kg"
        }

        acct.setDisplayHomeAsUpEnabled(true)


        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        var trueMonth : Int?
        var date : String ?

        val datePicker = DatePickerDialog(
                this,
        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            trueMonth = month + 1
            date = dayOfMonth.toString()+"/"+trueMonth+"/"+year
            tvDate.text = date
        },
        year,
        month,
        day
        )

        datePicker.show()

        tvDate.setOnClickListener {
            /* val nowDate = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->  } ,
                nowDate.get(Calendar.YEAR),nowDate.get(Calendar.MONTH),nowDate.get(Calendar.DAY_OF_MONTH))
            datePicker.show() */


            val datePicker = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    trueMonth = month + 1
                    date = dayOfMonth.toString()+"/"+trueMonth+"/"+year
                    tvDate.text = date
                },
                year,
                month,
                day
            )

            datePicker.show()

        }

        //getting values from the activity

        btnSave.setOnClickListener {

            var numWhole = 0f
            var numQtr = 0f
            var numHalf = 0f
            var num3qtr = 0f

            if (et_whole_qty.text.toString().isNotEmpty()){  numWhole = et_whole_qty.text.toString().toFloat()}
            if (et_qtr_qty.text.toString().isNotEmpty()){ numQtr = et_qtr_qty.text.toString().toFloat()}
            if (et_half_qty.text.toString().isNotEmpty()){  numHalf = et_half_qty.text.toString().toFloat()}
            if (et_3qtr_qty.text.toString().isNotEmpty()){  numWhole = et_3qtr_qty.text.toString().toFloat()}

           /* var qty = (numWhole + bagSize * ((numQtr * 0.25) + (numHalf * 0.5) +(num3qtr * 0.75))).toFloat()*/
            var qty = (numWhole * bagSize) + ( numQtr * (bagSize * 0.25) + numHalf * (bagSize * 0.5) + num3qtr * (bagSize * 0.75)).toFloat()

            var msg :String



            var level  = 0f // used to store the current level or feed quantity in the database before feed in actually used i.e if requried feed is greater than level then no feed must be used
            var id = 0 // used to store the id of the item of interest



            //initialising the the var level with the actual value from the database
            list.forEach{
                if(it.item==bagSize.toString()+"_kg_bag"){
                   level =  it.qty
                    Log.i("Quantity" , "qty : $level")
                    id = it.id
                }

            }

            Log.i("@Required ", "required: $qty")

            // getting the total amount of feed to be dispatched
            var requiredFeed  = qty
            var clossingFeed = level - requiredFeed



            if (requiredFeed > level){
                msg = "not enough feed of the selected type"
                Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()

            }else {

                if (tvDate.text.toString().equals("Select Date")) {
                    var msg = "Enter valid Date"
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                } else {

                    if (et_whole_qty.text.toString().isNullOrEmpty() && et_qtr_qty.text.toString().isNullOrEmpty() && et_half_qty.text.toString().isNullOrEmpty() && et_3qtr_qty.text.toString().isNullOrEmpty()) {
                        Toast.makeText(this, "Enter Quantity", Toast.LENGTH_SHORT).show()
                    } else {
                        var dailyDiaryActivity = DFU_Entity()
                        dailyDiaryActivity.date = tvDate.text.toString()
                        dailyDiaryActivity.feedType = bagSize.toString() + "_kg_bag"
                        dailyDiaryActivity.quatity = requiredFeed
                        dailyDiaryActivity.openningFeed = level
                        dailyDiaryActivity.clossingFeed = clossingFeed
                        dailyDiaryActivity.syncStatus = false

                        db.feedTaskDAO().saveFeedTask(dailyDiaryActivity)

                        // updating the database with the new level

                        var inventoryEntity = Inventory_Entity()
                        inventoryEntity.id = id
                        inventoryEntity.item = bagSize.toString() + "_kg_bag"
                        inventoryEntity.qty = clossingFeed

                        db.inventoryDAO().addMoreFeed(inventoryEntity)

                        msg = "feed records updated "
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

                        et_whole_qty.text.clear()
                        et_qtr_qty.text.clear()
                        et_half_qty.text.clear()
                        et_3qtr_qty.text.clear()
                    }

                }
            }

           Thread{
               db.feedTaskDAO().viewFeed().forEach{
               Log.i("@override","id : ${it.id}")
               Log.i("@override","date: ${it.date}")
               Log.i("@override","type : ${it.feedType}")
                   Log.i("@override","quantity : ${it.quatity}")
                   Log.i("@override","openning Feed: ${it.openningFeed}")
                   Log.i("@override","clossing Feed : ${it.clossingFeed}")
                   Log.i("@override","Status : ${it.syncStatus}")
               }


            }.start()

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}



