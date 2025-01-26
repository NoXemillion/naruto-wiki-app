package com.example.narutowiki.domain.use_cases

import android.content.res.Resources
import android.provider.Settings.Global.getString
import com.example.narutowiki.R
import com.example.narutowiki.common.Resource
import com.example.narutowiki.data.dataClasses.Character
import com.example.narutowiki.domain.AnimeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

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
                emit(Resource.Error(message = Resources.getSystem().getString(R.string.listEmptyError)))
            }
        }
        else{
            emit(Resource.Error(message = Resources.getSystem().getString(R.string.queryError)))
        }
    }.catch { e ->
        emit(Resource.Error(message = e.localizedMessage ?: animeRepository.getAllCharacters().errorBody().toString()))
    }
}