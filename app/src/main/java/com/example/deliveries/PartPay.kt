package com.example.deliveries

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_part_pay.*
import android.content.Intent
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import com.example.Database.*
import com.example.layers.MainActivity
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_daily_feed.*
import kotlinx.android.synthetic.main.activity_part_pay.tvDate
import java.util.*

class PartPay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part_pay)

        var mtitle: TextView = findViewById(R.id.tool_title)
        mtitle.text = "Deliveries"
        var back: Button = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB")
            .allowMainThreadQueries().build()

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


        btnPartSave.setOnClickListener {
            if (tvDate.text.toString().equals("Select a Date")) {
                var msg = "Enter valid Date"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            } else {

                //cash payment
                if (partPaid.text.toString().toInt() == (partQuantity.text.toString().toInt()) * (partPrice.text.toString().toInt())) {

                    var cashActivity = Part_Entity()
                    cashActivity.partDate = tvDate.text.toString()
                    cashActivity.partProduct = prodPartSpin.selectedItem.toString()
                    cashActivity.partQuantity = partQuantity.text.toString().toInt()
                    cashActivity.totalP =
                        (partQuantity.text.toString().toInt()) * (partPrice.text.toString().toInt())
                    cashActivity.type = "Cash"

                    db.partTask().savePartTask(cashActivity)

                    var msg = "Cash Purchase Made"
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                }

                //account payment
                if (partPaid.text.toString().toInt() == 0) {

                    var cashActivity = Part_Entity()
                    cashActivity.names = partCustomer.text.toString()
                    cashActivity.partDate = tvDate.text.toString()
                    cashActivity.partProduct = prodPartSpin.selectedItem.toString()
                    cashActivity.partQuantity = partQuantity.text.toString().toInt()
                    cashActivity.totalP =
                        (partQuantity.text.toString().toInt()) * (partPrice.text.toString().toInt())
                    cashActivity.owingP = cashActivity.totalP
                    cashActivity.type = "Account"

                    db.partTask().savePartTask(cashActivity)


                    var msg = "Account Purchase Made"
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                }

                //part payment
                if (partPaid.text.toString().toInt() < (partQuantity.text.toString().toInt()) * (partPrice.text.toString().toInt())) {

                    var partActivity = Part_Entity()
                    partActivity.names = partCustomer.text.toString()
                    partActivity.partDate = tvDate.text.toString()
                    partActivity.partProduct = prodPartSpin.selectedItem.toString()
                    partActivity.partQuantity = partQuantity.text.toString().toInt()
                    partActivity.totalP = (partQuantity.text.toString().toInt()) * (partPrice.text.toString().toInt())
                    partActivity.paidPart = partPaid.text.toString().toInt()
                    partActivity.owingP = partActivity.totalP - partActivity.paidPart
                    partActivity.type = "Part Payment"

                    db.partTask().savePartTask(partActivity)

                    var msg = "Part Payment Purchase Made"
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                }


                // reading quantity from the database

                var startStock: Int

                db.stockTask().viewStock().forEach {
                    startStock = it.stockQty

                    // updating the database with the new level

                    var stock = Stock_Entity()
                    stock.stockId = 1

                    var prePurchase = partQuantity.text.toString().toInt()
                    stock.stockItem = "Eggs"
                    stock.stockQty = startStock - prePurchase

                    db.stockTask().addMoreEggs(stock)

                }
            }


        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
