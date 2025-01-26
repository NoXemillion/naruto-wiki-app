package com.example.narutowiki.data.dataClasses

import com.google.gson.annotations.SerializedName


data class NinjaRank(
    @SerializedName("Boruto Manga")
    val borutoManga: String,
    @SerializedName("Part I")
    val partI: String,
    @SerializedName("Part II")
    val partII: String
)