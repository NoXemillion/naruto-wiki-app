package com.example.narutowiki.data

import android.util.Log
import com.example.narutowiki.data.dataClasses.Character
import com.example.narutowiki.domain.AnimeRepository
import com.google.gson.Gson
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Response

class AnimeRepositoryImpl(
    private val api: Api
): AnimeRepository {

    override suspend fun getAllCharacters(): Response<List<Character>> {
        Log.d("TAG3" ,"Result -> ${api.getAllCharacters().body().toString()}" )
        return Response.success(api.getAllCharacters().body()?.characters)
    }

    override suspend fun getCharacterById(id: Int): Response<Character> {
        return Response.success(api.getAllCharacters().body()?.characters?.get(id))
    }
}