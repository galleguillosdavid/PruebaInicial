package com.example.retrofit.model.Retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.model.Retrofit.rickandmorty.Inicio.dcPersonajesRAM
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository () {
    private val services = RetrofitClient.getRetrofitClient()
    val mLiveData : MutableLiveData<dcPersonajesRAM> = MutableLiveData()

    //la vieja confiable
    fun getDataFromServer() {
        val call2 = services.getDataFromApi()
        call2.enqueue(object : Callback<dcPersonajesRAM> {
            override fun onResponse(call: Call<dcPersonajesRAM>, response: Response<dcPersonajesRAM>) {
                when(response.code()){
                    in 200..299 -> mLiveData.postValue(response.body())
                    in 300..399 -> Log.d("ERROR 300", response.errorBody().toString())
                    in 400..499 -> Log.d("ERROR 400", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<dcPersonajesRAM>, t: Throwable) {
               Log.d("Repository", t.message.toString())
            }
        })
    }
}