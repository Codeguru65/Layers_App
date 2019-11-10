package com.example.layers

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.DFU_Entity
import com.example.Database.Inventory_Entity

import kotlinx.android.synthetic.main.activity_daily_diary.*
import java.util.*


class DailyDiaryActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_diary)
        setSupportActionBar(toolbar as Toolbar?)
        //var tTitle = toolbar.findViewById(R.id.title)


        var level10kg :Float? = null
        var level25kg :Float? = null
        var level50kg :Float? = null

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").build()







        val bundle : Bundle? = intent.extras
        val bagSize : Int = bundle!!.getInt("BAG_SIZE")

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

            var numWhole = et_whole_qty.text.toString().toDouble()
            var numQtr = et_qtr_qty.text.toString().toDouble()
            var numHalf = et_half_qty.text.toString().toDouble()
            var num3qtr = et_3qtr_qty.text.toString().toDouble()
            var qty = (numWhole + bagSize * ((numQtr * 0.25) + (numHalf * 0.5) +(num3qtr * 0.75))).toFloat()


            var list = db.inventoryDAO().viewFeed()



            Thread{

                var dailyDiaryActivity = DFU_Entity()
                dailyDiaryActivity.date=tvDate.text.toString()
                dailyDiaryActivity.feedType=bagSize.toString()+"KgBag"
                dailyDiaryActivity.quatity = qty
                dailyDiaryActivity.openningFeed = list[0].qty
                dailyDiaryActivity.clossingFeed = qty - list[0].qty
                dailyDiaryActivity.syncStatus=false

                db.feedTaskDAO().saveFeedTask(dailyDiaryActivity)
            }



           /* var num_whole = et_whole_qty.text.toString().toInt()
            var num_qtr  = et_qtr_qty.text.toString().toInt()
            var num_half = et_half_qty.text.toString().toInt()
            var num_3qtr = et_3qtr_qty.text.toString().toInt()
*/


            //quantity = whole + size[(10kg_num * fraction) + (25kg_num * faction) + (50kg_num * fraction)

           // var totalFeedTypeUsed = num_whole + bagSize * ((num_qtr * 0.25) + (num_half * 0.5) +(num_3qtr * 0.75))


           /* if(!TextUtils.isEmpty(et_whole_qty.text.toString())){
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

            */


           Thread{
               db.feedTaskDAO().viewFeed().forEach{
               Log.i("@override","id : ${it.id}")
               Log.i("@override","date: ${it.date}")
               Log.i("@override","qty : ${it.feedType}")
                   Log.i("@override","quantity : ${it.quatity}")
                   Log.i("@override","openning Feed: ${it.openningFeed}")
                   Log.i("@override","clossing Feed : ${it.clossingFeed}")
                   Log.i("@override","Status : ${it.syncStatus}")
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



