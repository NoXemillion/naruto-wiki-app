package com.example.narutowiki.domain.use_cases

import android.util.Log
import com.example.narutowiki.common.Resource
import com.example.narutowiki.data.AnimeRepositoryImpl
import com.example.narutowiki.data.dataClasses.Character
import com.example.narutowiki.domain.AnimeRepository
import com.example.narutowiki.presentation.AnimeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Response

class GetAnimeUseCase(
    private val animeRepository: AnimeRepository
) {
    operator fun invoke(
        characters: MutableList<Character>
    ): Flow<Resource<List<Character>>> = flow {
        emit(Resource.Loading())
        val anime = animeRepository.getAllCharacters()

        if(anime.isSuccessful){
            val animeInfo = anime.body()
            if(animeInfo != null){
                animeInfo.forEach{ item ->
                    characters.add(item)
                }
                emit(Resource.Success(animeInfo))
            }
            else{
                emit(Resource.Error(message = "List is empty"))
            }
        }
        else{
            emit(Resource.Error(message = "Query wasn't successfully"))
        }
    }.catch { e ->
        emit(Resource.Error(message = e.localizedMessage ?: animeRepository.getAllCharacters().errorBody().toString()))
    }
}