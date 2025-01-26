package com.example.narutowiki.data.dataClasses

import com.google.gson.annotations.SerializedName


data class Family(
    @SerializedName("adoptive brother")
    val adoptiveBrother: String,
    @SerializedName("adoptive father")
    val adoptiveFather: String,
    @SerializedName("adoptive son")
    val adoptiveSon: String,
    @SerializedName("brother")
    val brother: String,
    @SerializedName("cousin")
    val cousin: String,
    @SerializedName("depowered form")
    val depoweredForm: String,
    @SerializedName("father")
    val father: String,
    @SerializedName("husband")
    val husband: String,
    @SerializedName("incarnation with the god tree")
    val incarnationWithTheGodTree: String,
    @SerializedName("nephew")
    val nephew: String,
    @SerializedName("son")
    val son: String
)