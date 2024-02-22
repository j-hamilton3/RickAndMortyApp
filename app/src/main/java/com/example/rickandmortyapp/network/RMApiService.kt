package com.example.rickandmortyapp.network

import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import com.example.rickandmortyapp.network.RMCharacter


private const val BASE_URL =  "https://rickandmortyapi.com/api/"

// Initialize Json for Kotlinx Serialization
val json = Json { ignoreUnknownKeys = true }

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface RMApiService {
    @GET("character/1,2,3")
    suspend fun getCharacters(): List<RMCharacter>
}

object RMApi {
    val retrofitService : RMApiService by lazy {
        retrofit.create(RMApiService::class.java)
    }
}