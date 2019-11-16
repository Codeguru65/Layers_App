package com.example.layers

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Water_Entity
import kotlinx.android.synthetic.main.activity_daily_feed.*
import kotlinx.android.synthetic.main.activity_water.*
import kotlinx.android.synthetic.main.activity_water.tvDate
import java.util.*

class Water : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var mtitle: TextView = findViewById(R.id.tool_title)
        mtitle.text = "Water"
        var back: Button = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB")
            .allowMainThreadQueries().build()


        setContentView(R.layout.activity_water)
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)


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


        btn_water.setOnClickListener {
            // val intent = Intent(this, Submenu::class.java)


            var waterActivity = Water_Entity()
            waterActivity.wdate = tvDate.text.toString()
            waterActivity.level = spinner.isSelected.toString()

            db.waterTask().saveWaterTask(waterActivity)

            Thread {
                db.waterTask().viewWater().forEach {
                    Log.i("@override", "id : ${it.waterid}")
                    Log.i("@override", "date: ${it.wdate}")
                    Log.i("@override", "type : ${it.level}")


                    finish()
                }
            }
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()

    }
}
