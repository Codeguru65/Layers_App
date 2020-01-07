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
import com.example.dailythings.HistoryAdapter
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_daily__entries.*
import java.util.*
import kotlin.collections.ArrayList

class  Daily_Entries : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily__entries)

        var mtitle: TextView = findViewById(R.id.tool_title)
        mtitle.text = "Feed History"
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

//        tvDate.setOnClickListener {
//            /* val nowDate = Calendar.getInstance()
//            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->  } ,
//                nowDate.get(Calendar.YEAR),nowDate.get(Calendar.MONTH),nowDate.get(Calendar.DAY_OF_MONTH))
//            datePicker.show() */
//
//
//            val datePicker = DatePickerDialog(
//                this,
//                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
//                    trueMonth = month + 1
//                    date = dayOfMonth.toString()+"/"+trueMonth+"/"+year
//                    tvDate.text = date
//                },
//                year,
//                month,
//                day
//            )
//
//            datePicker.show()
//
//
//        }
        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB")
            .allowMainThreadQueries().build()



        search.setOnCloseListener{

            var date = search.



            var dataList = ArrayList<DataH>()

            db.feedTaskDAO().viewHistory(date).forEach{
                var item = DataH(it.feedType , it.quatity, it.id)

                dataList.add(item)

            }
            for (it in dataList){
                Log.i("@inventory"," description : ${it.description}")
            }

            val layout = LinearLayoutManager(this)
            layout.orientation = LinearLayoutManager.VERTICAL
            recyclerHistory.layoutManager = layout

            val adp = HistoryAdapter(this, dataList)
            recyclerHistory.adapter = adp
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
