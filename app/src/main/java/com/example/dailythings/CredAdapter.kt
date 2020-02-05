package com.example.dailythings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.layers.R
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.crediitors_item.view.*
import kotlinx.android.synthetic.main.debtors_item.view.*
import kotlinx.android.synthetic.main.feed_history_item.view.*
import kotlinx.android.synthetic.main.inventory_item.view.*
import kotlinx.android.synthetic.main.inventory_item.view.bag_description
import kotlinx.android.synthetic.main.inventory_item.view.qty

class CredAdapter (val context: Context,val  data: List<Data>): RecyclerView.Adapter<CredAdapter.MyVieiwHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVieiwHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.crediitors_item, parent,false)
        return MyVieiwHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyVieiwHolder, position: Int) {
        val data = data[position]
        holder.setData(data)


    }

    inner class MyVieiwHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun setData(data: Data?){
            itemView.cred_name.text = data!!.description
            itemView.cred_owed.text = data.quantity.toString()

        }

    }

}