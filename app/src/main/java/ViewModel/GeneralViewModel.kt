package ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.model.Repository
import com.example.retrofit.model.dcGeneral

class GeneralViewModel:ViewModel() {
    private val  repository= Repository()
    init {
        repository.getDataFromServer()
    }
    fun exposeLiveDataFromServer(): LiveData<List<dcGeneral>> {
        return repository.mLiveData
    }
}