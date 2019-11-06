package com.example.layers

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.deliveries.Deliveries
import com.example.production.Inventory
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Window
import android.widget.Button


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_daily_diary.setOnClickListener {
            showDiaryDialog()

        }

        /**
         * change the final method attached to the buttons i.e the finish() method
         */
        btn_deliveries.setOnClickListener {
            val intent = Intent(this, Deliveries::class.java)
            startActivity(intent)

        }
        btn_production.setOnClickListener {
            startActivity(Intent(this, Inventory::class.java))

        }
    }

    private fun showDiaryDialog() {
        // create an alert builder
        val dialog = Dialog(this@MainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.daily_tasts_dialog)


        var btn_feed: Button = dialog.findViewById(R.id.btn_feed)
        var btn_eggs: Button = dialog.findViewById(R.id.btn_eggs)

        btn_feed.setOnClickListener {
            showBagSizeDialog()
            dialog.dismiss()
        }

        dialog.show()
    }


    //this mothod is display the bag size dialogue
    private fun showBagSizeDialog() {
        // create an alert builder
        val dialog = Dialog(this@MainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.bag_size_dialog)



        var btn10Kg: Button = dialog.findViewById(R.id.btn_10kg_bag)
        var btn25kg: Button = dialog.findViewById(R.id.btn_10kg_bag)
        var btn50kg: Button = dialog.findViewById(R.id.btn_50kg_bag)


        //onclick listener for showing the feed activity loaded with relevent information
        btn10Kg.setOnClickListener {
            var intent = Intent(this@MainActivity, DailyDiaryActivity::class.java)
            val type : String = "10kg"
            intent.putExtra("BAG_SIZE", type)
            startActivity(intent)

            dialog.dismiss()
        }

        btn25kg.setOnClickListener {
            var intent = Intent(this@MainActivity, DailyDiaryActivity::class.java)
            val type : String = "25kg"
            intent.putExtra("BAG_SIZE", type)
            startActivity(intent)

            dialog.dismiss()
        }

        btn50kg.setOnClickListener {
            var intent = Intent(this@MainActivity, DailyDiaryActivity::class.java)
            val type : String = "50kg"
            intent.putExtra("BAG_SIZE", type)
            startActivity(intent)

            dialog.dismiss()
        }




        dialog.show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
//        val intent = Intent(this, LoginActivity::class.java)
//        startActivity(intent)

    }
}
