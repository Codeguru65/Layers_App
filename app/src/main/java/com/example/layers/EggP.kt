package com.example.layers

import android.app.DatePickerDialog
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Egg_Entity
import com.example.Database.Stock_Entity
import kotlinx.android.synthetic.main.activity_daily_feed.*
import kotlinx.android.synthetic.main.eggs.*
import kotlinx.android.synthetic.main.eggs.toolbar
import kotlinx.android.synthetic.main.eggs.tvDate
import kotlinx.android.synthetic.main.tool_bar.*
import java.lang.Exception
import java.util.*


class EggP : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.eggs)

        var mtitle: TextView = findViewById(R.id.tool_title)
        mtitle.text = "Egg Production"
        var back: Button = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }


        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()


        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        var whole: Int
        var qtr: Int
        var three_qrt: Int
        var half: Int


        var trueMonth: Int?


        var date: String?

        tvDate.setOnClickListener {
            /* val nowDate = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->  } ,
                nowDate.get(Calendar.YEAR),nowDate.get(Calendar.MONTH),nowDate.get(Calendar.DAY_OF_MONTH))
            datePicker.show() */


            val datePicker = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->


                    trueMonth = month + 1

                    date = dayOfMonth.toString() + "/" + trueMonth + "/" + year


                    tvDate.text = date
                },
                year,
                month,
                day
            )

            datePicker.show()


        }

        btnEggSave.setOnClickListener {

            if (tvDate.text.toString().equals("Select Date")) {
                var msg = "Enter valid Date"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            } else {

                if (eggPicked.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Please Enter Eggs Picked", Toast.LENGTH_SHORT).show()
                } else {
                    var bR: Int
                    //updating egg table
                    var dailyEggActivity = Egg_Entity()
                    dailyEggActivity.date = tvDate.text.toString()
                    dailyEggActivity.size = spinSize.selectedItem.toString()
                    dailyEggActivity.quality = spinQua.selectedItem.toString()
                    dailyEggActivity.picked = eggPicked.text.toString().toInt()

                    if (egBreak.text.isNullOrEmpty()) {
                        dailyEggActivity.broken = 0
                        bR = 0
                    } else {

                        dailyEggActivity.broken = egBreak.text.toString().toInt()
                        bR = egBreak.text.toString().toInt()
                    }
                    db.eggTaskDAO().saveEggTask(dailyEggActivity)

                    // updating the database with the new level

                    var startStock: Int

                    db.stockTask().viewStock().forEach {
                        startStock = it.stockQty

                        // updating the database with the new level

                        var stock = Stock_Entity()
                        stock.stockId = 1

                        var picked = eggPicked.text.toString().toInt() - bR
                        stock.stockItem = "Eggs"
                        stock.stockQty = startStock + picked

                        db.stockTask().addMoreEggs(stock)

                    }


                    var msg = "Saved"
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                    eggPicked.text.clear()
                    egBreak.text.clear()
                }
            }
        }
    }
        override fun onBackPressed() {
            super.onBackPressed()
            finish()
        }


}