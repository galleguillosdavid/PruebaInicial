package com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes


import com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.InfoP.InfoP
import com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.ResultP.ResultP
import com.google.gson.annotations.SerializedName

data class DcPersonajesRAM(
    @SerializedName("info")
    val info: InfoP,
    @SerializedName("results")
    val results: List<ResultP>
)