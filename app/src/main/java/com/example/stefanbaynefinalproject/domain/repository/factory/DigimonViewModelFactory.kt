package com.example.stefanbaynefinalproject.domain.repository.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stefanbaynefinalproject.domain.repository.DigimonRepositoryImpl
import com.example.stefanbaynefinalproject.domain.repository.viewmodel.DigimonViewModel
import java.lang.IllegalArgumentException

class DigimonViewModelFactory(private val digimonRepositoryImpl: DigimonRepositoryImpl): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DigimonViewModel::class.java))
        return DigimonViewModel(digimonRepositoryImpl) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }

}
