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

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _characters: MutableList<List<Character>> = mutableListOf()

    fun fetchAnimeData() {
        viewModelScope.launch {
            getAnimeUseCase().collect { result ->
                when(result){
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                    }
                    is Resource.Success -> {
                        result.data?.let { _characters.add(it) }
                        _isLoading.value = false
                    }
                }

            }
        }
    }

}