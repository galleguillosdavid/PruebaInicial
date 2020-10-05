package com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.ResultP


import com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.ResultP.LocationP.LocationP
import com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.ResultP.OriginP.OriginP
import com.google.gson.annotations.SerializedName

data class ResultP(
    @SerializedName("created")
    val created: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val location: LocationP,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: OriginP,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)