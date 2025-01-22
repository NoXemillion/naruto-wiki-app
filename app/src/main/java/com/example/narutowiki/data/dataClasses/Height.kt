package com.example.narutowiki.data.dataClasses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Height(
    @SerialName("Blank Period")
    val blankPeriod: String,
    @SerialName("Gaiden")
    val gaiden: String,
    @SerialName("Part I")
    val partI: String,
    @SerialName("Part II")
    val partII: String
)