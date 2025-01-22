package com.example.narutowiki.data.dataClasses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Naruto(
    @SerialName("characters")
    val characters: List<Character>,
    @SerialName("currentPage")
    val currentPage: Int,
    @SerialName("pageSize")
    val pageSize: Int,
    @SerialName("totalCharacters")
    val totalCharacters: Int
)