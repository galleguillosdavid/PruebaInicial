package com.example.retrofit.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.model.Personajes.RetrofitP.RetroP.RepositoryP
import com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.ResultP.ResultP

class ViewModelPersonajes:ViewModel() {
    private val  repository= RepositoryP()
    init {
        repository.getDataFromServer()
    }
    fun exposeLiveDataFromServer(): MutableLiveData<List<ResultP>> {
        return repository.mLiveData
    }
}