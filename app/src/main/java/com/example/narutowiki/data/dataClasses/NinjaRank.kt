package com.example.narutowiki.data.dataClasses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NinjaRank(
    @SerialName("Boruto Manga")
    val borutoManga: String,
    @SerialName("Part I")
    val partI: String,
    @SerialName("Part II")
    val partII: String
)