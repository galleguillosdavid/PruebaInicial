package com.example.retrofit.model.Personajes.RetrofitP.RetroP

import com.google.gson.annotations.SerializedName

data class dcGeneralP (val price: Long,
                       val id: String,
                       val type: String,
                       @SerializedName("img_src")val imgSrc: String)