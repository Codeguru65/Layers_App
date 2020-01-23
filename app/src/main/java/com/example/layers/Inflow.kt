package com.example.layers

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Debitors_Entity
import kotlinx.android.synthetic.main.activity_inflow.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_part_pay.*
import kotlinx.android.synthetic.main.activity_part_pay.tvDate
import java.util.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import com.example.Database.Part_Entity


class Inflow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inflow)

        var mtitle: TextView = findViewById(R.id.tool_title)
        mtitle.text = "Inflow"
        var back: Button = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }

        var db = Room.databaseBuilder(applicationContext,AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        var trueMonth: Int?
        var date: String?


        var datalist = db.debtTask().viewDebitors()
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

        //autoCompleting code

        var list = ArrayList<String?>()
        datalist.forEach {
           list.add(it.names)
        }

        val array = arrayOfNulls<String>(list.size)
        list.toArray(array)

        var adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line, array
        )
        var auto = findViewById<AutoCompleteTextView>(R.id.inCustomer)
                auto.setAdapter(adapter)

        //auto generating code
        inCustomer.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (inCustomer.text.isNullOrEmpty()){
                    inTotal.text = " 0"
                }
                else{
                    var customer = db.debtTask().viewDebt(inCustomer.text.toString())
                    if (customer.isNullOrEmpty()){
                        inTotal.text = " 0"
                    }
                    else {
                        customer.forEach {
                            inTotal.text = it.owingDebt.toString()
                        }
                    }

                }
            }
        })

        inPaid.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (inPaid.text.isNullOrEmpty() || inTotal.text.equals(" 0")){
                    inOwed.text = " 0"
                }
                else{
                    inOwed.text = (inTotal.text.toString().toFloat() - inPaid.text.toString().toFloat()).toString()
                }
            }
        })



        btnInSave.setOnClickListener {

            if (tvDate.text.toString().equals("Select a Date")) {
                var msg = "Enter a valid Date"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            } else {
                var customer = db.debtTask().viewDebt(inCustomer.text.toString())

                customer.forEach {
                    it.names = inCustomer.text.toString()
                    it.owingDebt =
                        inTotal.text.toString().toFloat() - inPaid.text.toString().toFloat()
                    it.debtDate = tvDate.text.toString()

                    db.debtTask().updateDebt(it)


                    var payActivity = Part_Entity()
                    payActivity.names = inCustomer.text.toString()
                    payActivity.type = " Due Payment"
                    payActivity.partDate = tvDate.text.toString()
                    payActivity.paidPart = inPaid.text.toString().toFloat()
                    payActivity.partProduct = "Eggs"
                    payActivity.totalP = inTotal.text.toString().toFloat()
                    payActivity.owingP =
                        inTotal.text.toString().toFloat() - inPaid.text.toString().toFloat()

                    db.partTask().savePartTask(payActivity)

                    var msg = "Payment Made"
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

                }

                inCustomer.text.clear()
                inTotal.text = " 0"
                inPaid.text.clear()
                inOwed.text = " 0"

            }
        }

    }
}
