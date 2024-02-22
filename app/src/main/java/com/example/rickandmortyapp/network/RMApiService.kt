/**
 * James Hamilton
 * February 22nd, 2024
 * ADEV 3007: Zacharie Montreuil
 */

package com.example.rickandmortyapp.network

import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

private const val BASE_URL =  "https://rickandmortyapi.com/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface RMApiService {
    @GET("character/1,2,3,4,5,6,7,8,9,10,11,12,13,14,15")
    suspend fun getCharacters(): List<RMCharacter>
}

object RMApi {
    val retrofitService : RMApiService by lazy {
        retrofit.create(RMApiService::class.java)
    }
}