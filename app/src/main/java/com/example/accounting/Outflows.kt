package com.example.accounting

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.Database.AppDb
import com.example.dailythings.DataH
import com.example.dailythings.OutAdapter
import com.example.dailythings.Trans
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_outflows.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class Outflows : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outflows)

        var acct = supportActionBar
        acct!!.title="Outflow Transactions"
        acct.setDisplayHomeAsUpEnabled(true)

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)


        var trueMonth: Int?
        var date: String?
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


        var db  = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()


        var dataList = ArrayList<Trans>()
        var total  = 0f
        db.payTask().viewPay().forEach{
            var item = Trans(it.nameS , it.payid, it.payDate, it.owingPay, it.totalPay, it.payType)
            total += it.totalPay
            dataList.add(item)

        }

        val layout = LinearLayoutManager(this)
        val adp = OutAdapter(this, dataList)

        layout.orientation = LinearLayoutManager.VERTICAL
        recyclerOut.layoutManager = layout
        recyclerOut.adapter = adp
        tot.text = total.toString()


        tvDate.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                dataList.clear()
                total = 0f
                db.payTask().viewPayD(tvDate.text.toString()).forEach{
                    var item = Trans(it.nameS , it.payid, it.payDate, it.owingPay, it.totalPay, it.payType)
                    total += it.totalPay
                    dataList.add(item)

                }
                adp.notifyDataSetChanged()
                layout.orientation = LinearLayoutManager.VERTICAL
                recyclerOut.layoutManager = layout
                recyclerOut.adapter = adp
                tot.text = total.toString()

            }

        })


    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
