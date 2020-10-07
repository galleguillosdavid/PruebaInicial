package com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.ResultP.OriginP


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class OriginP(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)