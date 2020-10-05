package com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.ResultP.LocationP


import com.google.gson.annotations.SerializedName

data class LocationP(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)