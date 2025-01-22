package com.example.narutowiki.data

import com.example.narutowiki.data.dataClasses.Character
import com.example.narutowiki.domain.AnimeRepository
import retrofit2.Response

class AnimeRepositoryImpl(
    private val api: api
): AnimeRepository {

    override suspend fun getAllCharacters(): Response<List<Character>> {
        return api.getAllCharacters()
    }

    override suspend fun getCharacterById(id: Int): Response<Character> {
        return api.getCharacterById(id)
    }
}