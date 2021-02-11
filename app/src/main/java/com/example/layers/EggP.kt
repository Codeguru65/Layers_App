package com.example.layers

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Egg_Entity
import com.example.Database.Stock_Entity
import kotlinx.android.synthetic.main.eggs.*
import kotlinx.android.synthetic.main.eggs.tvDate
import java.util.*


class EggP : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.eggs)

        var acct = supportActionBar
        acct!!.title = "Egg Production"
        acct.setDisplayHomeAsUpEnabled(true)


        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()


        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        var trueMonth: Int?

        var date: String?

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

        tvDate.setOnClickListener {

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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    override fun onBackPressed() {
            super.onBackPressed()
            finish()
        }


}