package com.example.retrofit.model.Personajes.Room


import androidx.room.Entity
import com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InfoP.InfoP
import com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.DcEntityResultP
import com.google.gson.annotations.SerializedName

@Entity(tableName = "DcEntityPersonajes_Table")
data class DcEntityPerRAM(
    @SerializedName("info")
    val info: InfoP,
    @SerializedName("results")
    val results: List<DcEntityResultP>
)