package com.example.Views

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.Database.AppDb
import com.example.dailythings.DataH
import com.example.dailythings.EggAdapter
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_egg__history.*
import java.util.*
import kotlin.collections.ArrayList

class Egg_History : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_egg__history)

        var mtitle: TextView = findViewById(R.id.tool_title)
        mtitle.text = "Egg Picking History"
        var back: Button = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)





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
        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB")
            .allowMainThreadQueries().build()



        buttonSearch.setOnClickListener {

            var date = tvDate.text.toString()



            var dataList = ArrayList<DataH>()

            db.eggTaskDAO().viewEggHistory(date).forEach{
                var item = DataH(it.size.toString() , it.broken.toFloat(), it.eggid)

                dataList.add(item)

            }
            for (it in dataList){
                Log.i("@inventory"," description : ${it.description}")
            }

            val layout = LinearLayoutManager(this)
            layout.orientation = LinearLayoutManager.VERTICAL
            recyclerEggHistory.layoutManager = layout

            val adp = EggAdapter(this, dataList)
            recyclerEggHistory.adapter = adp
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
