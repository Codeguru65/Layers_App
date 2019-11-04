package com.example.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailythings.Data
import com.example.layers.R
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedOptAdapter (val context: Context, val entities: List<Data>):RecyclerView.Adapter<FeedOptAdapter.MyCustomHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.feed_item,parent,false)
        return MyCustomHolder(view)
    }

    override fun getItemCount(): Int  = entities.size



    override fun onBindViewHolder(holder: MyCustomHolder, position: Int) {
        val entity = entities[position]
        holder.setData(entity)
    }

    class MyCustomHolder (itemView : View):RecyclerView.ViewHolder(itemView){

        fun setData ( entity: Data?){
            itemView.bag_description.text= entity!!.description
            itemView.qty.text=entity!!.quantity.toString()
        }
    }
}