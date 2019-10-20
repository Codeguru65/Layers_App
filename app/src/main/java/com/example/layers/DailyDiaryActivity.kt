package com.example.layers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.dailythings.AppDB
import com.example.dailythings.FeedEntity
import kotlinx.android.synthetic.main.activity_daily_diary.*


class DailyDiaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_diary)




        var dbnew = Room.databaseBuilder(applicationContext,AppDB::class.java,"LayersAppDatabase").build()
        var task2 = FeedEntity()



        btn_save.setOnClickListener {
            Thread{
                //task.date = etDate.text.toString()
                task2.feed_type5kg = etNum5kg.text.toString().toInt()
                task2.feed_type20kg = etNum20kg.text.toString().toInt()
                task2.feed_type50kg = etNum50kg.text.toString().toInt()

                dbnew.dailyTaskDao().saveTask(task2)

            }.start()
        }

        }

    }



