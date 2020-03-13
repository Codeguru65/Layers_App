package com.example.accounting

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.Database.AppDb
import com.example.dailythings.ClientAdapter
import com.example.dailythings.DataC
import kotlinx.android.synthetic.main.activity_clients.*
import android.view.Menu
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.example.layers.R


class Clients : AppCompatActivity() {

    lateinit var adp : ClientAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clients)

        var acct = supportActionBar
        acct!!.title = "Customer"
        acct.setDisplayHomeAsUpEnabled(true)


        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()

        var datalIst = ArrayList<DataC>()

        db.clientTask().viewSp("Customer").forEach {
            var item = DataC(it.nameClient, it.email, it.phone)
            datalIst.add(item)
        }

        var layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        recyclerClients.layoutManager = layout

        adp = ClientAdapter(this, datalIst)
        recyclerClients.adapter = adp


        newClient.setOnClickListener {
            startActivity(Intent(this, NewClient::class.java))
            finish()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        val searchItem = menu?.findItem(R.id.search)

        val searchView = searchItem?.actionView as SearchView


        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                adp.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adp.filter.filter(newText)
                return false

            }

        })

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }


}
