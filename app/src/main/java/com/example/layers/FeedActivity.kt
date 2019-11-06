package com.example.layers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import com.example.Adapters.FeedOptAdapter

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

    }

    override fun onBackPressed() {
        super.onBackPressed()
        setContentView(R.layout.daily_tasts_dialog)
    }
}
