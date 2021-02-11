package com.example.layers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private var mDrawerToggle : ActionBarDrawerToggle ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        title="expandable list view"

        val header : MutableList<String> = ArrayList()
        val body : MutableList<MutableList<String>> = ArrayList()

        val batches : MutableList<String> = ArrayList()
        batches.add("add batch")
        batches.add("view and manage batches")


        val tasks : MutableList<String> = ArrayList()
        tasks.add("feed")
        tasks.add("egg production")
        tasks.add("mortality")
        tasks.add("health")
        tasks.add("water")

        val accounting : MutableList<String> = ArrayList()
        accounting.add("customers")
        accounting.add("suppliers")
        accounting.add("debtors")
        accounting.add("creditors")
        accounting.add("transactions")

        val production : MutableList<String> = ArrayList()
//        production.add("view inventory")
//        production.add("view stoke")
        production.add("feed report")
        production.add("egg production")
//        production.add("purchase")
//        production.add("accounts payments")


        header.add("batches")
        header.add("tasks")
//        header.add("accounting")
//        header.add("outflow")
        header.add("production")



        body.add(batches)
        body.add(tasks)
//        body.add(accounting)
        body.add(production)

        expandable_list.setAdapter(ExpandableListAdapter(this,header,body))

        mDrawerToggle = ActionBarDrawerToggle(this,drawer_layout,tool_bar,R.string.open,R.string.close)
        mDrawerToggle!!.syncState()

    }


    fun update (view: View){
        var msg = (view as TextView).text
        //Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()

        when (msg){


            "add batch"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }

            "view and manage batches"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }

            "feed"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }
            "egg production "-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }
            "mortality"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }
            "health"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }
            "water"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }
            "customers"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }
            "suppliers"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }
            "debtors"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }
            "creditors"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }

            "transactions"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }

            "view inventory"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }
            "view stoke"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }

            "feed report"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }

            "egg prouction"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }

            "purchase"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }

            "accounts payments"-> {
                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
                drawer_layout.closeDrawer(GravityCompat.START)
            }
        }
    }
}
