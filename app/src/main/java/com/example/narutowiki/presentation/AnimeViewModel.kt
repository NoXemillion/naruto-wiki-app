package com.example.narutowiki.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.narutowiki.common.Resource
import com.example.narutowiki.data.dataClasses.Character
import com.example.narutowiki.domain.use_cases.GetAnimeUseCase
import kotlinx.coroutines.launch

class AnimeViewModel(
    private val getAnimeUseCase: GetAnimeUseCase
): ViewModel() {
    val characters: MutableList<Character> = mutableListOf()

    private val _isClicked = MutableLiveData<Boolean>(false)
    val isClicked: MutableLiveData<Boolean> get() = _isClicked

    private val _animeState = MutableLiveData<Resource<List<Character>>>()
    val animeState: LiveData<Resource<List<Character>>> get() = _animeState

    fun fetchAnimeState() {
        viewModelScope.launch {
            getAnimeUseCase(characters).collect{ state ->
                _animeState.postValue(state)
            }
        }
    }
}