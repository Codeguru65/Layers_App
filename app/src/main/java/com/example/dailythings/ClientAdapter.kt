package com.example.dailythings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filterable
import com.example.layers.R
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.client_item.view.*
import java.util.logging.Filter


class ClientAdapter (val context: Context,val  data: List<DataC>): RecyclerView.Adapter<ClientAdapter.MyVieiwHolder>(), Filterable{

    var filterList : List<DataC>

    init {
        filterList = data
    }
    override fun getFilter(): android.widget.Filter {
       return object : android.widget.Filter(){
           override fun performFiltering(p0: CharSequence?): FilterResults {
               val charearch = p0.toString()

               if (charearch.isNullOrEmpty()){
                   filterList = data
               }
               else{
                    var resultList = ArrayList<DataC>()

                   for (row in data){
                       if(row.name!!.toLowerCase().contains(charearch.toLowerCase()))
                           resultList.add(row)
                   }
                   filterList = resultList
               }
               val filterResult  = FilterResults()
               filterResult.values = filterList
               return filterResult
           }

           override fun publishResults(p0: CharSequence?, filterResults: FilterResults?) {
               filterList = filterResults?.values as List<DataC>
               notifyDataSetChanged()
           }
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVieiwHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.client_item, parent,false)
        return MyVieiwHolder(view)
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    override fun onBindViewHolder(holder: MyVieiwHolder, position: Int) {
        val dataZ = filterList[position]
        holder.setData(dataZ)

    }

    inner class MyVieiwHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun setData(data: DataC?){
            itemView.clientname.text = data!!.name
            itemView.clientType.text = data.type
            itemView.clientPhone.text = data.contact
        }
    }
}
