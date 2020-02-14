package com.example.dailythings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.layers.R
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.client_item.view.*
import kotlinx.android.synthetic.main.debtors_item.view.*
import kotlinx.android.synthetic.main.feed_history_item.view.*
import kotlinx.android.synthetic.main.inventory_item.view.*
import kotlinx.android.synthetic.main.inventory_item.view.bag_description
import kotlinx.android.synthetic.main.inventory_item.view.qty

class ClientAdapter (val context: Context,val  data: List<DataC>): RecyclerView.Adapter<ClientAdapter.MyVieiwHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVieiwHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.client_item, parent,false)
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
        fun setData(data: DataC?){
            itemView.clientname.text = data!!.name
            itemView.clientType.text = data.type
            itemView.clientPhone.text = data.contact

        }

    }

}