package com.example.retrofit.model.Retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("realestate")
    fun getDataFromApi(): Call<List<dcGeneral>>

}