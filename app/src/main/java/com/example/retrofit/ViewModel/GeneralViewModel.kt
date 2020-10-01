package com.example.retrofit.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.model.Retrofit.Repository
import com.example.retrofit.model.Retrofit.dcGeneral

class GeneralViewModel:ViewModel() {
    private val  repository= Repository()
    init {
        repository.getDataFromServer()
    }
    fun exposeLiveDataFromServer(): LiveData<List<dcGeneral>> {
        return repository.mLiveData
    }
}