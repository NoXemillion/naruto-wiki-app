package com.example.narutowiki.data.dataClasses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Age(
    @SerialName("Academy Graduate")
    val academyGraduate: String,
    @SerialName("Boruto Manga")
    val borutoManga: String,
    @SerialName("Chunin Promotion")
    val chuninPromotion: String,
    @SerialName("Part I")
    val partI: String,
    @SerialName("Part II")
    val partII: String
)