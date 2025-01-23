package com.example.narutowiki.data.dataClasses

import com.google.gson.annotations.SerializedName


data class Naruto(
    @SerializedName("characters")
    val characters: List<Character>,
    @SerializedName("currentPage")
    val currentPage: Int,
    @SerializedName("pageSize")
    val pageSize: Int,
    @SerializedName("totalCharacters")
    val totalCharacters: Int
)