package com.example.deliveries

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_part_pay.*
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.*
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
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

        //Database connection

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB")
            .allowMainThreadQueries().build()

        var startStock: Int

        var stockA = db.stockTask().viewStock()

        startStock = stockA[0].stockQty


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


        partQuantity.addTextChangedListener(object : TextWatcher{

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var a : CharSequence
                var b : Float
                if (partPrice.text.isNullOrEmpty()){
                    b = 0f
                }
                else {
                    b = partPrice.text.toString().toFloat()
                }

                if(s.isNullOrEmpty()){
                    a = "0"
                }
                else{
                    a = (b * s.toString().toFloat()).toString()
                }
                partTotal.setText(a.toString())
            }

        })

        partPrice.addTextChangedListener(object : TextWatcher{

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var a : Float
                if (partQuantity.text.toString().isNullOrEmpty()){
                    a = 0f
                }
                else {
                    a = partQuantity.text.toString().toFloat()
                }
                var b : CharSequence
                if (s.isNullOrEmpty()){
                    b = "0"
                }
                else{
                    b =  (a * s.toString().toFloat()).toString()
                }
                partTotal.text = (b.toString())
            }

        })

        var datalist = db.partTask().viewPart()
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
        var list = ArrayList<String?>()
        datalist.forEach {
            list.add(it.names)
        }

        val array = arrayOfNulls<String>(list.size)
        list.toArray(array)

        var rray = (array).toSet().toTypedArray()

        var adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line, rray
        )
        var auto = findViewById<AutoCompleteTextView>(R.id.partCustomer)
        auto.setAdapter(adapter)



        partPaid.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var a : CharSequence
                var b : Float
                if (partTotal.text.isNullOrEmpty()){
                    b = 0f
                }
                else {
                    b = partTotal.text.toString().toFloat()
                }
                if(s.isNullOrEmpty()){
                    a = "0"
                }
                else{
                    a = (b - s.toString().toFloat()).toString()
                }
                partOwed.setText(a.toString())
            }

        })

        btnPartSave.setOnClickListener {
            if (tvDate.text.toString().equals("Select a Date")) {
                var msg = "Enter valid Date"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            } else {

                // setting conditions for confirming sale

                if (startStock == 0) {
                    var msg = "No Available Stock"
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                } else {

                    //cash payment
                    if (paySpin.selectedItem.toString().equals("Cash")) {

                        var cashActivity = Part_Entity()
                        cashActivity.partDate = tvDate.text.toString()
                        cashActivity.partProduct = prodPartSpin.selectedItem.toString()
                        cashActivity.partQuantity = partQuantity.text.toString().toInt()
                        cashActivity.totalP =
                            (partQuantity.text.toString().toInt()) * (partPrice.text.toString().toFloat())
                        cashActivity.paidPart = partPaid.text.toString().toFloat()
                        cashActivity.type = "Cash"

                        db.partTask().savePartTask(cashActivity)

                        var msg = "Cash Purchase Made"
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                    }

                    //account payment
                    if (paySpin.selectedItem.toString().equals("Account")) {
                        if (partCustomer.text.isNullOrEmpty()) {
                            var msg = "Please Enter Customer Name"
                            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        } else {
                            var accActivity = Part_Entity()
                            accActivity.names = partCustomer.text.toString()
                            accActivity.partDate = tvDate.text.toString()
                            accActivity.partProduct = prodPartSpin.selectedItem.toString()
                            accActivity.partQuantity = partQuantity.text.toString().toInt()
                            accActivity.totalP =
                                (partQuantity.text.toString().toInt()) * (partPrice.text.toString().toFloat())
                            accActivity.paidPart = partPaid.text.toString().toFloat()
                            accActivity.owingP = accActivity.totalP
                            accActivity.type = "Account"

                            db.partTask().savePartTask(accActivity)

                            var msg = "Account Purchase Made"
                            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        }
                    }

                    //part payment
                    if (paySpin.selectedItem.toString().equals("Part Pay")) {
                        if (partCustomer.text.isNullOrEmpty()) {
                            var msg = "Please Enter Customer Name"
                            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        } else {
                            var partActivity = Part_Entity()
                            partActivity.names = partCustomer.text.toString()
                            partActivity.partDate = tvDate.text.toString()
                            partActivity.partProduct = prodPartSpin.selectedItem.toString()
                            partActivity.partQuantity = partQuantity.text.toString().toInt()
                            partActivity.totalP =
                                (partQuantity.text.toString().toInt()) * (partPrice.text.toString().toFloat())
                            partActivity.paidPart = partPaid.text.toString().toFloat()
                            partActivity.owingP = partActivity.totalP - partActivity.paidPart
                            partActivity.type = "Part Payment"

                            db.partTask().savePartTask(partActivity)

                            var msg = "Part Payment Purchase Made"
                            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        }
                    }


                    // reading quantity from the database

                    db.stockTask().viewStock().forEach {
                        //                    startStock = it.stockQty

                        // updating the database with the new level

                        var stock = Stock_Entity()
                        stock.stockId = 1

                        var prePurchase = partQuantity.text.toString().toInt()
                        stock.stockItem = "Eggs"
                        stock.stockQty = startStock - prePurchase

                        db.stockTask().addMoreEggs(stock)

                    }

                    var debt = Debitors_Entity()
                    debt.debtDate = tvDate.text.toString()
                    debt.names = partCustomer.text.toString()
                    var owing =
                        partTotal.text.toString().toFloat() - partPaid.text.toString().toFloat()


                    if (partPaid.text.toString().toFloat() < partTotal.text.toString().toFloat()) {
                        if (partCustomer.text.isNullOrEmpty()) {
                            var msg = "Please make sure to enter "
                        } else {
                            if ((db.debtTask().viewDebt(partCustomer.text.toString())).isNullOrEmpty()) {
                                debt.owingDebt = owing

                                db.debtTask().addDebt(debt)
                            } else {
                                var debtor = db.debtTask().viewDebt(partCustomer.text.toString())
                                debtor.forEach {
                                    debt.owingDebt = it.owingDebt + owing
                                    db.debtTask().updateDebt(debt)
                                }
                            }
                        }
                    }
                        partCustomer.text.clear()
                        partQuantity.text.clear()
                        partPrice.text.clear()
                        partTotal.text = " 0"
                        partPaid.text.clear()
                        partOwed.text = " 0"
                    }
                }
            }

        }



    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
