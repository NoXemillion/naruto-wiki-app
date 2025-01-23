package com.example.narutowiki.domain


import com.example.narutowiki.data.dataClasses.Character
import retrofit2.Response

interface AnimeRepository {

    suspend fun getAllCharacters(): Response<List<Character>>

    suspend fun getCharacterById(id: Int): Response<Character>

}