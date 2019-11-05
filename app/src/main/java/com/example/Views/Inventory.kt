package com.example.production

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layers.R
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailythings.Adapter
import com.example.dailythings.Supplier
import kotlinx.android.synthetic.main.activity_inventory.*

class Inventory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)



        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        recyclerView2.layoutManager = layout

        val  adp = Adapter(this, Supplier.entityList)
        recyclerView2.adapter = adp
    }

    override fun onBackPressed() {
        super.onBackPressed()
//        startActivity(Intent(this,ProdSub::class.java))
    }
}
