package com.example.narutowiki.data.dataClasses

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable



data class Age(
    @SerializedName("Academy Graduate")
    val academyGraduate: String,
    @SerializedName("Boruto Manga")
    val borutoManga: String,
    @SerializedName("Chunin Promotion")
    val chuninPromotion: String,
    @SerializedName("Part I")
    val partI: String,
    @SerializedName("Part II")
    val partII: String
)