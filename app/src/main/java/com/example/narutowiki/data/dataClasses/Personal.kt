package com.example.narutowiki.data.dataClasses


import com.google.gson.annotations.SerializedName


data class Personal(
    @SerializedName("affiliation")
    val affiliation: String,
    @SerializedName("age")
    val age: Age,
    @SerializedName("birthdate")
    val birthdate: String,
    @SerializedName("bloodType")
    val bloodType: String,
    @SerializedName("clan")
    val clan: String,
    @SerializedName("classification")
    val classification: String,
    @SerializedName("height")
    val height: Height,
    @SerializedName("jinchūriki")
    val jinchūriki: List<String>,
    @SerializedName("kekkeiGenkai")
    val kekkeiGenkai: String,
    @SerializedName("occupation")
    val occupation: String,
    @SerializedName("partner")
    val partner: String,
    @SerializedName("sex")
    val sex: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("team")
    val team: String,
    @SerializedName("titles")
    val titles: List<String>,
    @SerializedName("weight")
    val weight: Weight
)