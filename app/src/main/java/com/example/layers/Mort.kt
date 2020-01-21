package com.example.layers

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Bird_Entity
import com.example.Database.Mort_Entity
import kotlinx.android.synthetic.main.activity_daily_feed.*
import kotlinx.android.synthetic.main.activity_mort.*
import kotlinx.android.synthetic.main.activity_mort.tvDate
import java.util.*

class Mort : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mort)

        var mtitle: TextView = findViewById(R.id.tool_title)
        mtitle.text = "Mortality"
        var back : Button = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB")
            .allowMainThreadQueries().build()

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


        btn_mort.setOnClickListener {
            if (tvDate.text.toString().equals("Select Date")) {
                var msg = "Enter valid Date"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            } else {
                var mortActivity = Mort_Entity()
                mortActivity.mdate = tvDate.text.toString()

                var birdActivity = Bird_Entity()
                birdActivity.birdId = 1


                if(spinner.selectedItem.toString().equals("Other")){
                    if(mortOther.text.toString().isNotBlank()){
                    mortActivity.mcause = mortOther.text.toString()

                    }
                    else{
                        var msg  = "Enter Cause Description"
                        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    mortActivity.mcause = spinner.selectedItem.toString()

                    if (birdCount.text.isNotEmpty() && mortNum.text.isNullOrEmpty()) {
                        birdActivity.birdQty = birdCount.text.toString().toInt()
                        db.birdTask().addMoreBird(birdActivity)

                        var msg = " Bird Count Saved"
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        mortNum.text.clear()
                        mortOther.text.clear()
                        birdCount.text.clear()
                    } else if (mortNum.text.isNotEmpty() && birdCount.text.isNullOrEmpty()) {
                        mortActivity.mortNum = mortNum.text.toString().toInt()
                        db.mortTask().saveMortTask(mortActivity)

                        var msg = "Mortality Saved"
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        mortNum.text.clear()
                        mortOther.text.clear()
                        birdCount.text.clear()
                    } else {
                        mortActivity.mortNum = mortNum.text.toString().toInt()
                        birdActivity.birdQty = birdCount.text.toString().toInt()

                        db.birdTask().addMoreBird(birdActivity)
                        db.mortTask().saveMortTask(mortActivity)

                        var msg = "Saved"
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        mortNum.text.clear()
                        mortOther.text.clear()
                        birdCount.text.clear()
                    }
                }


                Thread {
                    db.mortTask().viewMort().forEach {
                        Log.i("@override", "id : ${it.mortid}")
                        Log.i("@override", "date: ${it.mdate}")
                        Log.i("@override", "type : ${it.mortNum}")


                        finish()
                    }
                }


            }
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()

    }
}
