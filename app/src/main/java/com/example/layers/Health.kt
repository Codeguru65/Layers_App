package com.example.layers

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Health_Entity
import kotlinx.android.synthetic.main.activity_daily_feed.*
import kotlinx.android.synthetic.main.health.*
import kotlinx.android.synthetic.main.health.tvDate
import java.util.*

class Health : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health)

        var acct = supportActionBar
        acct!!.title = "Health"
        acct.setDisplayHomeAsUpEnabled(true)

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB")
            .allowMainThreadQueries().build()

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        var trueMonth : Int?
        var date : String ?

        val datePicker2 = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener{
                    view, year, month, dayOfMonth ->
                trueMonth = month + 1
                date = dayOfMonth.toString()+"/"+trueMonth+"/"+year
                tvDate.text = date
            },
            year,
            month,
            day
        )

        datePicker2.show()


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


        btn_health.setOnClickListener {
            if (tvDate.text.toString().equals("Select Date")) {
                var msg = "Enter valid Date"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            } else {
                var hActivity = Health_Entity()
                hActivity.hdate = tvDate.text.toString()


                hActivity.healthS = hState.selectedItem.toString()



                if (hState.selectedItem.toString().equals("Good Weather")) {
                    db.healthTask().saveHealthTask(hActivity)
                    var msg = "Saved"
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                    healthOther.text.clear()


                } else {
                    if (hCause.selectedItem.toString().equals("Other")) {
                        if (healthOther.text.isNotBlank()){
                            hActivity.hcause = healthOther.text.toString()
                            db.healthTask().saveHealthTask(hActivity)
                            var msg = "Saved"
                            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                            healthOther.text.clear()
                        } else{
                            var msg = "Enter Reason"
                            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        }


                    } else {
                        hActivity.hcause = hCause.selectedItem.toString()
                        db.healthTask().saveHealthTask(hActivity)
                        var msg = "Saved"
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        healthOther.text.clear()
                    }
                }
                Thread {
                    db.healthTask().viewHealth().forEach {
                        Log.i("@override", "id : ${it.healthid}")
                        Log.i("@override", "date: ${it.hdate}")
                        Log.i("@override", "type : ${it.healthS}")


                        finish()
                    }
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