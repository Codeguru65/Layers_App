package com.example.layers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.Database.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var sp: SharedPreferences
        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB")
            .allowMainThreadQueries().build()
        sp = getSharedPreferences("logStatus",MODE_PRIVATE)


        if (sp.getBoolean("logged", false)) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()


        }else
        {
            btnLogin.setOnClickListener {
            var user = etUsername.text.toString()
            var pass = etPwd.text.toString()
            var userS = db.userTask().viewUser(user)
            var usse: List<User_Entity>? = db.userTask().checkUsers()
//            if (user.isBlank()) {
//                var msg = "Enter Login Information"
//                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//            } else {
//                if (usse?.size == 0) {
//                    var msg = "User not Found! Please Register"
//                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//                } else {
//                    if (user.equals(userS.username) && pass.equals(userS.password)) {
//                        val intent = Intent(this, MainActivity::class.java)
//                        sp.edit().putBoolean("logged",true).apply()
//                        startActivity(intent)
//                        finish()
//                    } else {
//                        var msg = "Incorrect password"
//                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//                    }
//
//                }
//            }

                val intent = Intent(this, MainActivity::class.java)
                sp.edit().putBoolean("logged",true).apply()
                startActivity(intent)
                finish()

            if (db.inventoryDAO().viewFeed().isNullOrEmpty()) {
                var inventoryEntity1 = Inventory_Entity()
                var inventoryEntity2 = Inventory_Entity()
                var inventoryEntity3 = Inventory_Entity()
                inventoryEntity1.item = "10kg Bags"
                inventoryEntity1.qty = 0f
                inventoryEntity2.item = "25kg Bags"
                inventoryEntity2.qty = 0f
                inventoryEntity3.item = "50kg Bags"
                inventoryEntity3.qty = 0f

                db.inventoryDAO().addtem(inventoryEntity1)
                db.inventoryDAO().addtem(inventoryEntity2)
                db.inventoryDAO().addtem(inventoryEntity3)

            }
            if (db.stockTask().viewStock().isNullOrEmpty()) {
                var stock = Stock_Entity()
                stock.stockItem = "Eggs"
                stock.stockQty = 0

                db.stockTask().addEggs(stock)
            }
            if (db.birdTask().viewBird().isNullOrEmpty()){
                var bird = Bird_Entity()
                bird.birdQty = 0

                db.birdTask().addBird(bird)
            }


        }
            tvRegister.setOnClickListener {
                startActivity(Intent(this, SignUpActivity::class.java))
                finish()
            }
    }
    }
}

