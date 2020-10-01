package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.model.dcGeneral
import kotlinx.android.synthetic.main.item_list_view.view.*

class GeneralAdapter(var mPassMars: Mars): RecyclerView.Adapter<GeneralAdapter.TaskViewHolder>() {
    private var dataList = emptyList<dcGeneral>()// paso 1
    fun updateListM(mDataList:List<dcGeneral>){// paso 2
        dataList=mDataList
        notifyDataSetChanged()
    }
    inner class TaskViewHolder (itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener { // paso 3
        val imgTerrain = itemView.imageView
        val itemView = itemView.setOnClickListener(this)

       override  fun onClick(p0: View?) {//paso 5
        mPassMars.passMars(dataList[adapterPosition])
       }

    }
// esto se impleemtna despues del paso 4
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
     val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view, parent,false)
    return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val mTerrain: dcGeneral = dataList[position]
        Glide.with(holder.itemView.context).load(mTerrain.imgSrc).into(holder.imgTerrain)
    }

    override fun getItemCount(): Int = dataList.size

    interface Mars{ //Paso 6
        fun passMars(mTerrain: dcGeneral)
    }
}