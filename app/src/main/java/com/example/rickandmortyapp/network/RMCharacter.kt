/**
 * James Hamilton
 * February 22nd, 2024
 * ADEV 3007: Zacharie Montreuil
 */

package com.example.rickandmortyapp.network

import kotlinx.serialization.Serializable

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
    val origin: OriginLocation,
    val location: OriginLocation,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)



