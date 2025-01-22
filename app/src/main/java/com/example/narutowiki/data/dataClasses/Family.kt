package com.example.narutowiki.data.dataClasses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Family(
    @SerialName("adoptive brother")
    val adoptiveBrother: String,
    @SerialName("adoptive father")
    val adoptiveFather: String,
    @SerialName("adoptive son")
    val adoptiveSon: String,
    @SerialName("brother")
    val brother: String,
    @SerialName("cousin")
    val cousin: String,
    @SerialName("depowered form")
    val depoweredForm: String,
    @SerialName("father")
    val father: String,
    @SerialName("husband")
    val husband: String,
    @SerialName("incarnation with the god tree")
    val incarnationWithTheGodTree: String,
    @SerialName("nephew")
    val nephew: String,
    @SerialName("son")
    val son: String
)