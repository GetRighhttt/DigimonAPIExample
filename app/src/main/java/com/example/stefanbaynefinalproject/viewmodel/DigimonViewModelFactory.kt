package com.example.stefanbaynefinalproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stefanbaynefinalproject.repository.DigimonRepositoryImpl
import java.lang.IllegalArgumentException

class DigimonViewModelFactory(private val digimonRepositoryImpl: DigimonRepositoryImpl): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DigimonViewModel::class.java))
        return DigimonViewModel(digimonRepositoryImpl) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }

}
