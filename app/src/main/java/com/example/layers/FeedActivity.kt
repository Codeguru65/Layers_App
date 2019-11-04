package com.example.layers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Adapters.FeedOptAdapter
import com.example.dailythings.Supplier
import kotlinx.android.synthetic.main.activity_daily_diary.*
import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.android.synthetic.main.eggs.*

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)


       /* val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        feed_recycler_view.layoutManager = layoutManager

        val adapter = FeedOptAdapter(this,Supplier.entityList)
        feed_recycler_view.adapter = adapter
*/
        tvDate.setOnClickListener {
            Toast.makeText(this,"editText initiated toast msg",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setContentView(R.layout.activity_submenu)
    }
}
