package com.example.retrofit.model.Personajes.RetrofitP.RetroP

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientP {
    companion object{
        private const val URL_BASE = "https://rickandmortyapi.com/api/"


        fun getRetrofitClient(): ApiInterfaceP {
            val mCRetrofit = Retrofit.Builder().baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mCRetrofit.create(ApiInterfaceP::class.java)
        }
    }
}