package com.example.stefanbaynefinalproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stefanbaynefinalproject.model.Digimon
import com.example.stefanbaynefinalproject.repository.DigimonRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

// ViewModel for providing AllDigimon fragment with UI elements
// ViewModels save the state of configuration, and work well with LiveData
class DigimonViewModel
    (private val repositoryImpl: DigimonRepositoryImpl): ViewModel() {

    // LiveData is a wrapper class for observable data
    private val _digimonData = MutableLiveData<List<Digimon>>()
    val digimonData get() = _digimonData

    // init initializes data when the ViewModel(or object) is first called
    init {
        getDigimonData()
    }

    // method to get all the DigimonData and use Coroutines to suspend the operation
    // to another thread.
    fun getDigimonData() {
        CoroutineScope(IO).launch {
            val response = repositoryImpl.getDigiData()
            _digimonData.postValue(response)
        }
    }
}