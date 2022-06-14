package com.example.stefanbaynefinalproject.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interface for the API call.
 * In the API, there were 3 parameters.
 * However, none were queries. All were endpoints.
 * @GET and @Path implementation down below.
 */

interface Api {

    @GET("digimon/")
    suspend fun getDigiData(): Response<List<Digimon>>

    @GET("name/{name}")
    suspend fun getDigiName(
        @Path("name") name: String
    ): Response<Digimon>

    @GET("level/{level}")
    suspend fun getDigiLevels(
        @Path("level") level: String
    ):Response<List<Digimon>>

    /**
     base URL - https://digimon-api.vercel.app/api/digimon
     name - https://digimon-api.vercel.app/api/digimon/name/:name
    level - https://digimon-api.vercel.app/api/digimon/level/:level
     */

    // static object to create an instance of our Retrofit2 for RESTful API information
    companion object {
        private var instance: Api? = null
        fun getDigimonApi(): Api {
            if(instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl("https://digimon-api.vercel.app/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Api::class.java)
            }
            return instance!!
        }
    }
}