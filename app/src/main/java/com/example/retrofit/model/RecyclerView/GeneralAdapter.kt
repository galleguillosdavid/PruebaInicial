package com.example.retrofit.model.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.model.Retrofit.dcGeneral
import kotlinx.android.synthetic.main.item_list_view.view.*

class GeneralAdapter(var mPassGeneral: General): RecyclerView.Adapter<GeneralAdapter.TaskViewHolder>() {
    private var dataList = emptyList<dcGeneral>()// paso 1
    fun updateListM(mDataList:List<dcGeneral>){// paso 2
        dataList=mDataList
        notifyDataSetChanged()
    }
    inner class TaskViewHolder (itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener { // paso 3
        val imgGeneral = itemView.imageView
        val itemView = itemView.setOnClickListener(this)

       override  fun onClick(p0: View?) {//paso 5
           mPassGeneral.passGeneral(dataList[adapterPosition])
       }

    }
// esto se impleemtna despues del paso 4
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
     val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view, parent,false)
    return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val mdcGeneral: dcGeneral = dataList[position]
        Glide.with(holder.itemView.context).load(mdcGeneral.imgSrc).into(holder.imgGeneral)
    }

    override fun getItemCount(): Int = dataList.size

    interface General{ //Paso 6
        fun passGeneral(mdcGeneral: dcGeneral)
    }
}