package com.example.rickandmortyapp.network

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class OriginLocation(
    val name: String,
    val url: String
)

@Serializable
data class RMCharacter(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginLocation, // Corrected from List<String> to OriginLocation
    val location: OriginLocation, // Corrected from List<String> to OriginLocation
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)



