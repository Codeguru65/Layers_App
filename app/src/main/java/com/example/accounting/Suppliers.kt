package com.example.accounting

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.Database.AppDb
import com.example.dailythings.ClientAdapter
import com.example.dailythings.DataC
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_clients.*

class Suppliers : AppCompatActivity() {
    lateinit var adp : ClientAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suppliers)

        var acct = supportActionBar
        acct!!.title = "Supplier"
        acct.setDisplayHomeAsUpEnabled(true)

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()

        var datalIst = ArrayList<DataC>()

        db.clientTask().viewSp("Supplier").forEach {
            var item = DataC(it.nameClient, it.email, it.phone)
            datalIst.add(item)
        }

        var layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        recyclerClients.layoutManager = layout

        adp = ClientAdapter(this, datalIst)
        recyclerClients.adapter = adp


        newClient.setOnClickListener {
            startActivity(Intent(this, NewSupplier::class.java))
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
