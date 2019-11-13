package com.example.deliveries

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_part_pay.*
import android.content.Intent
import com.example.layers.MainActivity
import kotlinx.android.synthetic.main.activity_daily_feed.*
import kotlinx.android.synthetic.main.activity_part_pay.tvDate
import java.util.*

class PartPay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part_pay)

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

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}
