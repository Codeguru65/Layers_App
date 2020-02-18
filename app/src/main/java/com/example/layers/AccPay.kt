package com.example.layers

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Creditors_Entity
import com.example.Database.Payment_Entity
import kotlinx.android.synthetic.main.activity_acc_pay.*
import kotlinx.android.synthetic.main.activity_acc_pay.tvDate
import kotlinx.android.synthetic.main.activity_payments.*
import java.util.*

class AccPay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acc_pay)


        var acct  = supportActionBar
        acct!!.title="Account Payments"
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

        payAccSupplier.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (payAccSupplier.text.isNullOrEmpty()){
                    payAccTotal.text = " 0"
                }
                else{
                    var customer = db.credTask().viewCred(payAccSupplier.text.toString())
                    if (customer.isNullOrEmpty()){
                        payAccTotal.text = " 0"
                    }
                    else {
                        customer.forEach {
                            payAccTotal.text = it.owingCred.toString()
                        }
                    }

                }
            }
        })

        payAccPaid.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (payAccPaid.text.isNullOrEmpty() || payAccTotal.text.equals(" 0")){
                    payAccOwing.text = " 0"
                }
                else{
                    payAccOwing.text = (payAccTotal.text.toString().toFloat() - payAccPaid.text.toString().toFloat()).toString()
                }
            }
        })

        //auto completing name
        var datalist = db.credTask().viewCreditors()

        //autoCompleting code

        var lis = ArrayList<String?>()
        datalist.forEach {
            lis.add(it.credNames)
        }

        val array = arrayOfNulls<String>(lis.size)
        lis.toArray(array)

        var rray = (array).toSet().toTypedArray()

        var adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line, rray
        )
        var auto = findViewById<AutoCompleteTextView>(R.id.payAccSupplier)
        auto.setAdapter(adapter)

        btnPayAccSave.setOnClickListener {

            if (tvDate.text.toString().equals("Select a Date")) {
                var msg = "Enter valid Date"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }
            else {
                if (payAccSupplier.text.isNullOrEmpty()  || payAccPaid.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Enter All Values", Toast.LENGTH_SHORT).show()
                } else {

                    var payAct = Payment_Entity()
                    payAct.payProduct = "Account Payment"
                    payAct.payQuantity = 0
                    payAct.paidPay = payAccPaid.text.toString().toFloat()
                    payAct.nameS = payAccSupplier.text.toString()
                    payAct.totalPay = payAccTotal.text.toString().toFloat()
                    payAct.payDate = tvDate.text.toString()
                    payAct.owingPay = payAccOwing.text.toString().toFloat()
                    payAct.payType = "Account Payment"

                    var cred = Creditors_Entity()
                    cred.credDate = tvDate.text.toString()

                    //saving the transaction

                    db.payTask().savePayTask(payAct)

                    var deb = db.credTask().viewCred(payAccSupplier.text.toString())

                    deb.forEach {
                        cred.credNames = it.credNames
                        cred.owingCred = it.owingCred - payAccPaid.text.toString().toFloat()
                        cred.credId = it.credId

                        db.credTask().updateCred(cred)
                    }

                    var msg = "Purchase Made"
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

                    payAccSupplier.text.clear()
                    payAccTotal.text = " 0"
                    payAccPaid.text.clear()
                    payAccOwing.text = " 0"
                }
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
