package com.example.accounting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Client_Entity
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_new_supplier.*

class NewSupplier : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_supplier)

        var acct = supportActionBar
        acct!!.title= "New Supplier"
        acct.setDisplayHomeAsUpEnabled(true)

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()

        var client = Client_Entity()

        btnClients.setOnClickListener {

            if (sname.text.isNullOrEmpty() || emailS.text.isNullOrEmpty() || addressS.text.isNullOrEmpty() || phoneS.text.isNullOrEmpty()) {
                Toast.makeText(this, "Enter All Details", Toast.LENGTH_SHORT).show()
            } else {
                client.nameClient = sname.text.toString()
                client.email = emailS.text.toString()
                client.address = addressS.text.toString()
                client.phone = phoneS.text.toString()
                client.clientType = "Supplier"

                db.clientTask().addClient(client)

                sname.text.clear()
                emailS.text.clear()
                addressS.text.clear()
                phoneS.text.clear()

                startActivity(Intent(this, Clients::class.java))
                finish()

            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}
