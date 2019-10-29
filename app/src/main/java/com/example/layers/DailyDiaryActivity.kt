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


    }

}



