package com.example.accounting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.Client_Entity
import com.example.layers.LoginActivity
import com.example.layers.R
import kotlinx.android.synthetic.main.activity_new_client.*

class NewClient : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_client)

        var acct = supportActionBar
        acct!!.title= "New Customer"
        acct.setDisplayHomeAsUpEnabled(true)

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()

        var client = Client_Entity()

        btnClient.setOnClickListener {

            if (cname.text.isNullOrEmpty() || email.text.isNullOrEmpty() || addressC.text.isNullOrEmpty() || phone.text.isNullOrEmpty()) {
                Toast.makeText(this, "Enter All Details", Toast.LENGTH_SHORT).show()
            } else {
                client.nameClient = cname.text.toString()
                client.email = email.text.toString()
                client.address = addressC.text.toString()
                client.phone = phone.text.toString()
                client.clientType = "Customer"

                db.clientTask().addClient(client)

                cname.text.clear()
                email.text.clear()
                addressC.text.clear()
                phone.text.clear()

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
