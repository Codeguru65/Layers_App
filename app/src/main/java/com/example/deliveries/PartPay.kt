package com.example.deliveries

import android.app.DatePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_part_pay.*
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.room.Room
import com.example.Database.*
import com.example.accounting.NewClient
import com.example.accounting.NewSupplier
import com.example.layers.MainActivity
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_daily_feed.*
import kotlinx.android.synthetic.main.activity_part_pay.tvDate
import java.util.*

class PartPay : AppCompatActivity() {

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        startActivity(Intent(this, NewClient::class.java))
    }
    val negativeButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            "Cancel", Toast.LENGTH_SHORT).show()
    }
    val neutralButtonClick = { dialog: DialogInterface, which: Int ->
        startActivity(Intent(this, NewSupplier::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part_pay)

        var acct = supportActionBar
        acct!!.title = "Deliveries"
        acct.setDisplayHomeAsUpEnabled(true)
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

        var datalist = db.clientTask().viewClient()


        // auto completion code

        var list = ArrayList<String?>()
        datalist.forEach {
            list.add(it.nameClient)
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
            }
            else {
                if (partQuantity.text.isNullOrEmpty() || partPrice.text.isNullOrEmpty() || partPaid.text.isNullOrEmpty()) {
                    Toast.makeText(
                        this,
                        " Please Enter All Relevant Fields",
                        Toast.LENGTH_SHORT
                    ).show()
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

                        val dat = db.clientTask().veiwClient()

                        //account payment
                        if (paySpin.selectedItem.toString().equals("Account")) {
                            if (partCustomer.text.isNullOrEmpty()) {
                                var msg = "Please Enter Customer Name"
                                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                            } else {

                                if(dat.isNullOrEmpty()){
                                    basicAlert()
                                }
                                else {
                                    var accActivity = Part_Entity()
                                    accActivity.names = partCustomer.text.toString()
                                    accActivity.partDate = tvDate.text.toString()
                                    accActivity.partProduct = prodPartSpin.selectedItem.toString()
                                    accActivity.partQuantity = partQuantity.text.toString().toInt()
                                    accActivity.totalP =
                                        (partQuantity.text.toString().toInt()) * (partPrice.text.toString().toFloat())
                                    accActivity.paidPart = partPaid.text.toString().toFloat()

                                    if(partPaid.text.equals("0")) {
                                        accActivity.owingP = accActivity.totalP
                                    }
                                    else{
                                        accActivity.owingP = accActivity.totalP - accActivity.paidPart
                                    }
                                    accActivity.type = "Account"

                                    db.partTask().savePartTask(accActivity)

                                    var msg = "Account Purchase Made"
                                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                                }
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

                        //updating debts

                        var debt = Client_Entity()
                        debt.balDate = tvDate.text.toString()
                        debt.nameClient = partCustomer.text.toString()
                        var owing = partTotal.text.toString().toFloat() - partPaid.text.toString().toFloat()
                        
                        if (partPaid.text.toString().toFloat() < partTotal.text.toString().toFloat()) {
                            if (partCustomer.text.isNullOrEmpty()) {
                                var msg = "Please make sure to enter Customer name "
                                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                            } else {
                                        db.clientTask().viewD(partCustomer.text.toString()).forEach {
                                        debt.owing = it.owing + owing
                                        db.clientTask().updateClient(debt)
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

        }

    private fun basicAlert() {
        val builder = AlertDialog.Builder(this)
        with(builder)
        {
            setTitle("Account Not Found")
            setMessage("Create New Account?")
            setPositiveButton("Customer", DialogInterface.OnClickListener(function = positiveButtonClick))
            setNegativeButton("Cancel", negativeButtonClick)
            setNeutralButton("Supplier", DialogInterface.OnClickListener(function = neutralButtonClick))
            show()
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
