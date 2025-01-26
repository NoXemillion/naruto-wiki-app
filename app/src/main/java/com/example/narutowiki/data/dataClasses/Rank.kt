package com.example.narutowiki.data.dataClasses

import com.google.gson.annotations.SerializedName


data class Rank(
    @SerializedName("ninjaRank")
    val ninjaRank: NinjaRank,
    @SerializedName("ninjaRegistration")
    val ninjaRegistration: String
)