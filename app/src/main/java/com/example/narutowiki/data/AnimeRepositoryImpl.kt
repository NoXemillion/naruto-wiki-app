package com.example.narutowiki.data

import android.util.Log
import com.example.narutowiki.data.dataClasses.Character
import com.example.narutowiki.domain.AnimeRepository
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Response

class AnimeRepositoryImpl(
    private val api: Api
): AnimeRepository {

    override suspend fun getAllCharacters(): Response<List<Character>> {
        val response = api.getAllCharacters()
        if(response.isSuccessful){
            val characters = response.body()?.characters
            Log.d("TAG3", "Result -> $characters")
            return Response.success(characters)
        }
        else {
            Log.e("TAG3", "Error: ${response.errorBody()?.string()}")
            return Response.error(response.code(), response.errorBody() ?: ResponseBody.create(null, "Unknown error"))
        }

    }

    override suspend fun getCharacterById(id: Int): Response<Character> {
        return Response.success(api.getAllCharacters().body()?.characters?.get(id))
    }
}