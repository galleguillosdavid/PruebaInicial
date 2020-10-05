package com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.InfoP


import com.google.gson.annotations.SerializedName

data class InfoP(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("prev")
    val prev: Any
)