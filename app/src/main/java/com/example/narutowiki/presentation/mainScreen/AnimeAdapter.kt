package com.example.narutowiki.presentation.mainScreen

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ListAdapter
import coil.load
import com.example.narutowiki.R
import com.example.narutowiki.data.dataClasses.Character
import com.example.narutowiki.domain.use_cases.GetAnimeUseCase
import com.example.narutowiki.presentation.AnimeViewModel

class AnimeAdapter(
    private val animeViewModel: AnimeViewModel
) : ListAdapter<Character, AnimeViewHolder>(AnimeDiffCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view,parent,false)
        return AnimeViewHolder(view ,animeViewModel)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(position)
    }
}