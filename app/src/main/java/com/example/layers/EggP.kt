package com.example.layers

import android.app.DatePickerDialog
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Egg_Entity
import kotlinx.android.synthetic.main.activity_daily_feed.*
import kotlinx.android.synthetic.main.eggs.*
import kotlinx.android.synthetic.main.eggs.toolbar
import kotlinx.android.synthetic.main.eggs.tvDate
import java.lang.Exception
import java.util.*


class EggP : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.eggs)
//        setSupportActionBar(toolbar as Toolbar?)
        //var tTitle = toolbar.findViewById(R.id.title)



        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").build()


        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        var whole : Int
        var qtr : Int
        var three_qrt : Int
        var half :Int




        var trueMonth : Int?


        var date : String ?

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

        btnEggSave.setOnClickListener {
            Thread{
                var dailyEggActivity = Egg_Entity()
                dailyEggActivity.date = tvDate.text.toString()
                dailyEggActivity.size= spinSize.selectedItem.toString()
                dailyEggActivity.quality= spinQua.selectedItem.toString()
                dailyEggActivity.picked = eggPicked.text.toString().toInt()
                dailyEggActivity.broken = egBreak.text.toString().toInt()


                db.eggTaskDAO().saveEggTask(dailyEggActivity)
            }.start()

        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,MainActivity::class.java))
    }

}