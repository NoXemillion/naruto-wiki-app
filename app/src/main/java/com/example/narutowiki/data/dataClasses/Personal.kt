package com.example.narutowiki.data.dataClasses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Personal(
    @SerialName("affiliation")
    val affiliation: String,
    @SerialName("age")
    val age: Age,
    @SerialName("birthdate")
    val birthdate: String,
    @SerialName("bloodType")
    val bloodType: String,
    @SerialName("clan")
    val clan: String,
    @SerialName("classification")
    val classification: String,
    @SerialName("height")
    val height: Height,
    @SerialName("jinchūriki")
    val jinchūriki: List<String>,
    @SerialName("kekkeiGenkai")
    val kekkeiGenkai: String,
    @SerialName("occupation")
    val occupation: String,
    @SerialName("partner")
    val partner: String,
    @SerialName("sex")
    val sex: String,
    @SerialName("species")
    val species: String,
    @SerialName("status")
    val status: String,
    @SerialName("team")
    val team: String,
    @SerialName("titles")
    val titles: List<String>,
    @SerialName("weight")
    val weight: Weight
)