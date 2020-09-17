package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.model.Terrain
import kotlinx.android.synthetic.main.item_list_view.view.*

class MarsAdapter(var mPassMars: Mars): RecyclerView.Adapter<MarsAdapter.TaskViewHolder>() {
    private var dataList = emptyList<Terrain>()// paso 1
    fun updateList(mDataList:List<Terrain>){// paso 2
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
        val mTerrain: Terrain = dataList[position]
        Glide.with(holder.itemView.context).load(mTerrain.imgSrc).into(holder.imgTerrain)
    }

    override fun getItemCount(): Int = dataList.size

    interface Mars{ //Paso 6
        fun passMars(mTerrain: Terrain)
    }
}