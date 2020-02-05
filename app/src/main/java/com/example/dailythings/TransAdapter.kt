package com.example.dailythings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.layers.R
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.trans_item.view.*

class TransAdapter (val context: Context,val  data: List<DataH>): RecyclerView.Adapter<TransAdapter.MyVieiwHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVieiwHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.trans_item, parent,false)
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
        fun setData(data: DataH?){
            itemView.issueDate.text = data!!.date
            itemView.amount.text = data.quantity.toString()
            itemView.numRef.text = data!!.description
        }

    }

}