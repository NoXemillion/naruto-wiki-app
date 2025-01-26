package com.example.narutowiki.data.dataClasses


import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class Character(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("debut")
    val debut: Debut,
    @SerializedName("jutsu")
    val jutsu: List<String>,
    @SerializedName("family")
    val family: Family,
    @SerializedName("natureType")
    val natureType: List<String>,
//    @SerializedName("personal")
//    val personal: Personal,
    @SerializedName("rank")
    val rank: Rank,
    @SerializedName("tools")
    val tools: List<String>,
    @SerializedName("uniqueTraits")
    val uniqueTraits: List<String>,
//    @SerializedName("voiceActors")
//    val voiceActors: VoiceActors
    var IsFavourite: Boolean = false
)

data class Title(
    val name: String,
    val rank: String?,
    val image: String
)
