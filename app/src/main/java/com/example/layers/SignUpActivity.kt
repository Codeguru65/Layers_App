package com.example.layers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.Database.AppDb
import com.example.Database.User_Entity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_sign_up)

    var mtitle: TextView = findViewById(R.id.tool_title)
    mtitle.text = "Sign Up"
    var back: Button = findViewById(R.id.back)
    back.setOnClickListener {
        onBackPressed()
    }


    var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "LayersAppDB").allowMainThreadQueries().build()

    btnSign.setOnClickListener {
        if ((fname.text.toString().isBlank())||(lname.text.toString().isBlank())||(email.text.toString().isBlank())||(user.text.toString().isBlank())||(pass.text.toString().isBlank())||(conPass.text.toString().isBlank())) {
            var msg = "Please Enter All information"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        } else {


            if (pass.text.toString().equals(conPass.text.toString())) {
                var userActivity = User_Entity()

                userActivity.fname = fname.text.toString()
                userActivity.lname = lname.text.toString()
                userActivity.email = pass.text.toString()
                userActivity.username = user.text.toString()
                userActivity.password = conPass.text.toString()


                db.userTask().addUser(userActivity)


                var msg = "Registered Please login"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                fname.text.clear()
                lname.text.clear()
                email.text.clear()
                user.text.clear()
                pass.text.clear()
                conPass.text.clear()

                startActivity(Intent(this,LoginActivity::class.java))
                finish()



            }else{
                var msg = "Password Mismatch"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                conPass.text.clear()
                pass.text.clear()
        }




        }

    }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }
}
