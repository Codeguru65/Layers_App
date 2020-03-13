package com.example.layers

import android.app.Application
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.Database.*
import com.example.accounting.NewClient
import com.example.accounting.NewSupplier
import kotlinx.android.synthetic.main.activity_payments.*
import java.util.*

class Payments : AppCompatActivity() {

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
        setContentView(R.layout.activity_payments)

        var acct  = supportActionBar
        acct!!.title="Purcahse"
        acct.setDisplayHomeAsUpEnabled(true)

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

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB")
            .allowMainThreadQueries().build()

        var list = db.inventoryDAO().viewFeed()


        payQuantity.addTextChangedListener(object : TextWatcher{

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var a : CharSequence
                var b : Float
                if (payPrice.text.isNullOrEmpty()){
                    b = 0f
                }
                else {
                    b = payPrice.text.toString().toFloat()
                }

                if(s.isNullOrEmpty()){
                    a = "0"
                }
                else{
                    a = (b * s.toString().toFloat()).toString()
                }
                payTotal.setText(a.toString())
            }

        })

        payPrice.addTextChangedListener(object : TextWatcher{

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var a : Float
                if (payQuantity.text.toString().isNullOrEmpty()){
                    a = 0f
                }
                else {
                    a = payQuantity.text.toString().toFloat()
                }
                var b : CharSequence
                if (s.isNullOrEmpty()){
                    b = "0"
                }
                else{
                    b =  (a * s.toString().toFloat()).toString()
                }
                payTotal.text = (b.toString())
            }

        })

        payPaid.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var a : CharSequence
                var b : Float
                if (payTotal.text.isNullOrEmpty()){
                    b = 0f
                }
                else {
                    b = payTotal.text.toString().toFloat()
                }
                if(s.isNullOrEmpty()){
                    a = "0"
                }
                else{
                    a = (b - s.toString().toFloat()).toString()
                }
                payOwing.setText(a.toString())
            }

        })


        //auto completing name
        var datalist = db.clientTask().viewClient()

        //autoCompleting code

        var lis = ArrayList<String?>()
        datalist.forEach {
            lis.add(it.nameClient)
        }

        val array = arrayOfNulls<String>(lis.size)
        lis.toArray(array)

        var rray = (array).toSet().toTypedArray()

        var adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line, rray
        )
        var auto = findViewById<AutoCompleteTextView>(R.id.paySupplier)
        auto.setAdapter(adapter)

        btnPaySave.setOnClickListener {
            if (tvDate.text.toString().equals("Select a Date")) {
                var msg = "Enter valid Date"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            } else {

                if (paySupplier.text.isNullOrEmpty() || payQuantity.text.isNullOrEmpty() || payPrice.text.isNullOrEmpty() || payPaid.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Enter All Values", Toast.LENGTH_SHORT).show()
                } else {

                    if (db.clientTask().viewD(paySupplier.text.toString()).isNullOrEmpty()) {
                        basicAlert()
                    } else {
                        //payment
                        // object

                        var payAct = Payment_Entity()
                        payAct.payProduct = prodSpin.selectedItem.toString()
                        payAct.payQuantity = payQuantity.text.toString().toInt()
                        payAct.paidPay = payPaid.text.toString().toFloat()
                        payAct.nameS = paySupplier.text.toString()
                        payAct.totalPay = payTotal.text.toString().toFloat()
                        payAct.payDate = tvDate.text.toString()
                        payAct.owingPay = payOwing.text.toString().toFloat()
                        payAct.payType = "Purchase"

                        //inventory
                        //object

                        var inAct = Inventory_Entity()
                        var birdActivity = Bird_Entity()
                        birdActivity.birdId = 1

                        //cred
                        //object

                        var cred = Client_Entity()
                        cred.balDate = tvDate.text.toString()

                        //saving a purchase
                        if (payOwing.text.toString().toFloat() == 0f) {

                            if (paySupplier.text.isNullOrEmpty()) {
                                payAct.nameS = "General Supplier"
                            }
                            db.payTask().savePayTask(payAct)
                        } else {
                            if (paySupplier.text.isNullOrEmpty()) {
                                var msg = "Enter supplier name"
                                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                            } else {

                                //saving to payments
                                db.payTask().savePayTask(payAct)

                                //updating to credit
                                db.clientTask().viewD(paySupplier.text.toString()).forEach {
                                        cred.nameClient = it.nameClient
                                        cred.owed = it.owed + payOwing.text.toString().toFloat()
                                        cred.clientID = it.clientID
                                        cred.owing = it.owing
                                        cred.phone = it.phone
                                        cred.address = it.address
                                        cred.email = it.email
                                        cred.clientType = it.clientType
                                        db.clientTask().updateClient(cred)
                                    }
                                }
                            }


                        when (prodSpin.selectedItem.toString()) {
                            "Feed 10kg" -> {
                                db.inventoryDAO().readFeed(1).forEach {
                                    inAct.id = 1
                                    inAct.item = list[0].item
                                    inAct.qty =
                                        it.qty + (payQuantity.text.toString().toFloat() * 10.toFloat())

                                    db.inventoryDAO().addMoreFeed(inAct)
                                }
                            }
                            "Feed 25kg" -> {
                                db.inventoryDAO().readFeed(2).forEach {
                                    inAct.id = 2
                                    inAct.item = list[1].item
                                    inAct.qty =
                                        it.qty + (payQuantity.text.toString().toFloat() * 25.toFloat())

                                    db.inventoryDAO().addMoreFeed(inAct)
                                }
                            }
                            "Feed 50kg" -> {
                                db.inventoryDAO().readFeed(3).forEach {
                                    inAct.id = 3
                                    inAct.item = list[2].item
                                    inAct.qty =
                                        it.qty + (payQuantity.text.toString().toFloat() * 50.toFloat())

                                    db.inventoryDAO().addMoreFeed(inAct)
                                }
                            }
                            "Birds" -> {
                                db.birdTask().viewBird().forEach {
                                    var cur = it.birdQty

                                    birdActivity.birdQty = cur + payQuantity.text.toString().toInt()

                                    db.birdTask().addMoreBird(birdActivity)
                                }
                            }
                        }

                        var msg = "Purchase Made"
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

                        paySupplier.text.clear()
                        payQuantity.text.clear()
                        payPrice.text.clear()
                        payTotal.text = " 0"
                        payPaid.text.clear()
                        payOwing.text = " 0"
                    }
                }
            }
        }

    }
    private fun basicAlert(){
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
        finish()
        return true
    }
}



