package com.example.narutowiki.data.dataClasses

import com.google.gson.annotations.SerializedName


data class VoiceActors(
    @SerializedName("english")
    val english: String,
    @SerializedName("japanese")
    val japanese: String
)