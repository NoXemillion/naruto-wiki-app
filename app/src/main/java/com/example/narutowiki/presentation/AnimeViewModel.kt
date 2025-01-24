package com.example.narutowiki.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.narutowiki.common.Resource
import com.example.narutowiki.data.dataClasses.Character
import com.example.narutowiki.data.dataClasses.Rank
import com.example.narutowiki.data.dataClasses.Title
import com.example.narutowiki.domain.use_cases.GetAnimeUseCase
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class AnimeViewModel(
    private val getAnimeUseCase: GetAnimeUseCase
): ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    val characters: MutableList<Character> = mutableListOf()
    val titleInfoList: MutableList<Title> = mutableListOf()

    init {
        fetchAnimeData()
    }

    private fun fetchAnimeData() {
        viewModelScope.launch {
            getAnimeUseCase().collect { result ->
                when(result){
                    is Resource.Loading -> {
                        _isLoading.value = true
                        Log.d("TAG" , "Loading..")
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                        Log.d("TAG" , result.data.toString())
                    }
                    is Resource.Success -> {
                        _isLoading.value = false
                        _isLoading.postValue(false)
                        Log.d("TAG55" , "isLoading value -> ")
                        result.data?.forEach { item ->
                            characters.add(item)
                            Log.d("TAG55" , "авпвапва")
//                            if(item.rank != null){
//                                titleInfoList.add(
//                                    Title(
//                                        item.name,
//                                        item.rank.toString(),
//                                        item.images[item.id]
//                                    )
//                                )
//                            }
//                            else{
//                                titleInfoList.add(
//                                    Title(
//                                        item.name,
//                                        null,
//                                        item.images[item.id]
//                                    )
//                                )
//                            }

                        }

                    }
                }

            }
        }
    }

}