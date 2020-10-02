package com.example.retrofit.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.model.Retrofit.Repository
import com.example.retrofit.model.Retrofit.dcGeneral
import com.example.retrofit.model.Retrofit.rickandmorty.Inicio.dcPersonajesRAM

class GeneralViewModel:ViewModel() {
    private val  repository= Repository()
    init {
        repository.getDataFromServer()
    }
    fun exposeLiveDataFromServer(): MutableLiveData<List<dcPersonajesRAM>> {
        return repository.mLiveData
    }
}