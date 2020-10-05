package com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.ResultP.OriginP


import com.google.gson.annotations.SerializedName

data class OriginP(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)