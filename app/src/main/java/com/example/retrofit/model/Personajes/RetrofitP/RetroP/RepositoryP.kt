package com.example.retrofit.model.Personajes.RetrofitP.RetroP

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.ResultP.ResultP
import com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.DcPersonajesRAM
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryP () {
    private val services = RetrofitClientP.getRetrofitClient()
    val mLiveData = MutableLiveData<List<ResultP>>(emptyList())

    //la vieja confiable
    fun getDataFromServer() {
        val call2 = services.getDataFromApi()
        call2.enqueue(object : Callback<DcPersonajesRAM> {
            override fun onResponse(call: Call<DcPersonajesRAM>, response: Response<DcPersonajesRAM>) {
               Log.d("Resul",response.body().toString())
                when(response.code()){
                    in 200..299 -> mLiveData.postValue(response.body()?.results)//
                    in 300..399 -> Log.d("ERROR 300", response.errorBody().toString())
                    in 400..499 -> Log.d("ERROR 400", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<DcPersonajesRAM>, t: Throwable) {
               Log.d("Repository", t.message.toString())
            }
        })
    }
}