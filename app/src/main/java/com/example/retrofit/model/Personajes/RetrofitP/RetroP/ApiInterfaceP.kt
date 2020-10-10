//c 8 m:51
package com.example.retrofit.model.Personajes.RetrofitP.RetroP

import com.example.retrofit.model.Personajes.Room.DcEntityPerRAM
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterfaceP {
    @GET("character")
    fun getDataFromApi(): Call<DcEntityPerRAM>
}