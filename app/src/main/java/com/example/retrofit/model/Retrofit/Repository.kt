package com.example.retrofit.model.Retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository () {
    private val services = RetrofitClient.getRetrofitClient()
    val mLiveData : MutableLiveData<List<dcGeneral>> = MutableLiveData()

    //la vieja confiable
    fun getDataFromServer() {
        val call = services.getDataFromApi()
        call.enqueue(object : Callback<List<dcGeneral>> {
            override fun onResponse(call: Call<List<dcGeneral>>, response: Response<List<dcGeneral>>) {
                when(response.code()){
                    in 200..299 -> mLiveData.postValue(response.body())
                    in 300..399 -> Log.d("ERROR 300", response.errorBody().toString())
                    in 400..499 -> Log.d("ERROR 400", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<List<dcGeneral>>, t: Throwable) {
               Log.d("Repository", t.message.toString())
            }
        })
    }
}