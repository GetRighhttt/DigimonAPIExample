package com.example.stefanbaynefinalproject.repository

import com.example.stefanbaynefinalproject.model.Api
import com.example.stefanbaynefinalproject.model.Digimon

// Our repository to hold all the methods necessary for implementation
interface Repository {
    suspend fun getDigiData(): List<Digimon>
    suspend fun getDigiName(name: String): Digimon
    suspend fun getDigiLevel(level: String): List<Digimon>
}

// Repository implementation where we define our methods
class DigimonRepositoryImpl(private val service: Api = Api.getDigimonApi()): Repository {

    // Method to get all the digimon from the API
    override suspend fun getDigiData(): List<Digimon> {
        val response = service.getDigiData()
        return if((response.isSuccessful)) {
            response.body()!!
        } else {
            emptyList()
        }
    }

    // Method to get the Name for the Digimon
    override suspend fun getDigiName(name: String): Digimon {
        val response = service.getDigiName(name = name)
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            Digimon("Digimon not found", "Image Not Found", "Level Not Found")
        }
    }

    // Method to get the Digimon Level
    override suspend fun getDigiLevel(level: String): List<Digimon> {
        val response = service.getDigiLevels(level = level)
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            emptyList()
        }
    }
}