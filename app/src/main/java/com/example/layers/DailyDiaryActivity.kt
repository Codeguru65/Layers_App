package com.example.layers

import android.app.DatePickerDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.Window
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.Database.AppDb
import com.example.Database.DFU_Entity

import kotlinx.android.synthetic.main.activity_daily_diary.*
import java.util.*


class DailyDiaryActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_diary)
        setSupportActionBar(toolbar as Toolbar?)
        //var tTitle = toolbar.findViewById(R.id.title)



        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").build()




        val bundle : Bundle? = intent.extras
        val bagSize : String? = bundle!!.getString("BAG_SIZE")

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        var whole : Int
        var qtr : Int
        var three_qrt : Int
        var half :Int




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

        //getting values from the activity


        btnSave.setOnClickListener {
            if(!TextUtils.isEmpty(et_whole_qty.text.toString())){
                whole = et_whole_qty.text.toString().toInt()

                Thread{
                    var dailyFeedActivity = DFU_Entity()
                    dailyFeedActivity.date = tvDate.text.toString()
                    dailyFeedActivity.feedType = bagSize+"whole"
                    dailyFeedActivity.quatity=et_whole_qty.text.toString().toInt()

                    db.feedTaskDAO().saveFeedTask(dailyFeedActivity)
                }.start()




                //Toast.makeText(this,"whole bags added",Toast.LENGTH_SHORT).show()
            }else{
               // Toast.makeText(this,"no 3/4 bags",Toast.LENGTH_SHORT).show()
            }

            if(!TextUtils.isEmpty(et_qtr_qty.text.toString())){
                qtr = et_whole_qty.text.toString().toInt()
                Thread{
                    var dailyFeedActivity = DFU_Entity()
                    dailyFeedActivity.date = tvDate.text.toString()
                    dailyFeedActivity.feedType = bagSize+"quarter"
                    dailyFeedActivity.quatity=et_qtr_qty.text.toString().toInt()

                    db.feedTaskDAO().saveFeedTask(dailyFeedActivity)
                }.start()
                // Toast.makeText(this,"quarter bags added",Toast.LENGTH_SHORT).show()
            }else{
                //Toast.makeText(this,"no 3/4 bags",Toast.LENGTH_SHORT).show()
            }

            if(!TextUtils.isEmpty(et_half_qty.text.toString())){
                half = et_whole_qty.text.toString().toInt()
                Thread{
                    var dailyFeedActivity = DFU_Entity()
                    dailyFeedActivity.date = tvDate.text.toString()
                    dailyFeedActivity.feedType = bagSize+"half"
                    dailyFeedActivity.quatity=et_half_qty.text.toString().toInt()

                    db.feedTaskDAO().saveFeedTask(dailyFeedActivity)
                }.start()
                //Toast.makeText(this,"half bags added",Toast.LENGTH_SHORT).show()
            }else{
                //Toast.makeText(this,"no 3/4 bags",Toast.LENGTH_SHORT).show()
            }

            if(!TextUtils.isEmpty(et_3qtr_qty.text.toString())){
                three_qrt = et_whole_qty.text.toString().toInt()
                Thread{
                    var dailyFeedActivity = DFU_Entity()
                    dailyFeedActivity.date = tvDate.text.toString()
                    dailyFeedActivity.feedType = bagSize+"3 quarter"
                    dailyFeedActivity.quatity=et_3qtr_qty.text.toString().toInt()

                    db.feedTaskDAO().saveFeedTask(dailyFeedActivity)
                }.start()
                Toast.makeText(this,"3 quarter bags added",Toast.LENGTH_SHORT).show()
            }else{
               // Toast.makeText(this,"no 3/4 bags",Toast.LENGTH_SHORT).show()
            }


           Thread{
               db.feedTaskDAO().viewFeed().forEach{
               Log.i("@override","id : ${it.id}")
               Log.i("@override","date : ${it.date}")
               Log.i("@override","feedType : ${it.feedType}")
               Log.i("@override","quantity: ${it.quatity}")
               }


            }.start()

        }


        // data entry logic


    }



    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}



