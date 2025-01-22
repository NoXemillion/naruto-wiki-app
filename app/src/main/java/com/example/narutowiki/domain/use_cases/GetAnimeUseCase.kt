package com.example.narutowiki.domain.use_cases

import com.example.narutowiki.common.Resource
import com.example.narutowiki.data.dataClasses.Character
import com.example.narutowiki.domain.AnimeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.Response

class GetAnimeUseCase(
    private val animeRepository: AnimeRepository
) {

    operator fun invoke(): Flow<Resource<List<Character>>> = flow {
        try{
            emit(Resource.Loading())
//            val anime = withContext(Dispatchers.IO){
//                animeRepository.getAllCharacters().body()
//            }

            val anime = animeRepository.getAllCharacters().body()
            if(anime != null){
                emit(Resource.Success(anime))
            }else{
                emit(Resource.Error(message = animeRepository.getAllCharacters().errorBody().toString()))
            }
        }
        catch (e: Exception){
            emit(Resource.Error(message = e.localizedMessage ?: animeRepository.getAllCharacters().errorBody().toString()))
        }
    }
}