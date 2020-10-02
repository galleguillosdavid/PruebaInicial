// antes de este crear el item list
//antes del item list trabajar en el firstfragment
//c 10 m 1:03 aprox
package com.example.retrofit.model.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.model.Retrofit.rickandmorty.Inicio.dcPersonajesRAM
import kotlinx.android.synthetic.main.item_list_view.view.*

class GeneralAdapter(var mpassPersonajesRAM: RAM): RecyclerView.Adapter<GeneralAdapter.ThisViewHolder>() {
    private var dataList = emptyList<dcPersonajesRAM>()

    fun updatelistRM(mDataList: List<dcPersonajesRAM>){
        dataList = mDataList
    }

    inner class ThisViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

       var imgRM = itemView.imageView
        var itemView = itemView.setOnClickListener(this)//c9 m1:30


        override fun onClick(v: View?) {
            mpassPersonajesRAM.enviardatos(dataList[adapterPosition])
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThisViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view,parent,false)//c9 1:42
        return ThisViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ThisViewHolder, position: Int) {//c9 m 1:57
        val obtainPosition : dcPersonajesRAM = dataList[position]
       Glide.with(holder.itemView.context).load(obtainPosition).into(holder.imgRM)
    }

    override fun getItemCount() = dataList.size

    interface RAM {
        fun enviardatos(mdcPersonajesRAM: dcPersonajesRAM)
    }


}
