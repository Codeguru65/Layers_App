package com.example.layers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import com.example.dailythings.AppDB

import kotlinx.android.synthetic.main.activity_daily_diary.*


class DailyDiaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_diary)



        setSupportActionBar(toolbar as Toolbar?)

    }

}



