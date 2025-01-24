package com.example.narutowiki.data


import com.example.narutowiki.data.dataClasses.Character
import com.example.narutowiki.data.dataClasses.Naruto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/api/character?page=1&limit=200")
    suspend fun getAllCharacters(): Response<Naruto>

    @GET("/api/character/{id}")
    suspend fun getCharacterById(@Path("id") characterId: Int): Response<Naruto>

}