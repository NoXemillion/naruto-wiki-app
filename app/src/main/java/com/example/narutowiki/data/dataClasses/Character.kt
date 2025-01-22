package com.example.narutowiki.data.dataClasses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Character(
    @SerialName("debut")
    val debut: Debut,
    @SerialName("family")
    val family: Family,
    @SerialName("id")
    val id: Int,
    @SerialName("images")
    val images: List<String>,
    @SerialName("jutsu")
    val jutsu: List<String>,
    @SerialName("name")
    val name: String,
    @SerialName("natureType")
    val natureType: List<String>,
    @SerialName("personal")
    val personal: Personal,
    @SerialName("rank")
    val rank: Rank,
    @SerialName("tools")
    val tools: List<String>,
    @SerialName("uniqueTraits")
    val uniqueTraits: List<String>,
    @SerialName("voiceActors")
    val voiceActors: VoiceActors
)