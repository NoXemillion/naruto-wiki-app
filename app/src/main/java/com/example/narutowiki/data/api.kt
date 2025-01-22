package com.example.narutowiki.data

import com.example.narutowiki.data.dataClasses.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface api {

    @GET("/api/character")
    suspend fun getAllCharacters(): Response<List<Character>>

    @GET("/api/character/{id}")
    suspend fun getCharacterById(@Path("id") characterId: Int): Response<Character>

}