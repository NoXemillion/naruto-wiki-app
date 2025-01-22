package com.example.narutowiki.data.dataClasses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rank(
    @SerialName("ninjaRank")
    val ninjaRank: NinjaRank,
    @SerialName("ninjaRegistration")
    val ninjaRegistration: String
)