package com.example.narutowiki.data.dataClasses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VoiceActors(
    @SerialName("english")
    val english: String,
    @SerialName("japanese")
    val japanese: String
)