package com.example.narutowiki.presentation.mainScreen

import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.narutowiki.R
import com.example.narutowiki.domain.use_cases.GetAnimeUseCase
import com.example.narutowiki.presentation.AnimeViewModel

class AnimeViewHolder(
    itemView: View,
    private val animeViewModel: AnimeViewModel
): RecyclerView.ViewHolder(itemView){

    fun bind(position: Int) {
        var character = animeViewModel.characters[position]

        val name: TextView = itemView.findViewById(R.id.name)
        val cardViewBackground: ImageView = itemView.findViewById(R.id.cardViewBackground)
        val favouriteIcon: ImageButton = itemView.findViewById(R.id.characterIcon)

        name.text = character.name

        if (character.images.isNullOrEmpty()) {
            cardViewBackground.setImageResource(R.drawable.error_icon)
        } else {
            cardViewBackground.load(character.images.first()) {
                Log.d("TAG" , character.images.first().toString())
                crossfade(true)
                placeholder(R.drawable.error_icon)
                error(R.drawable.error_icon)
            }
        }

        if(character.IsFavourite){
            favouriteIcon.setImageResource(R.drawable.baseline_favorite_24)
        }
        else {
            favouriteIcon.setImageResource(R.drawable.baseline_favorite_border_24)
        }

        favouriteIcon.setOnClickListener{
            character.IsFavourite = !character.IsFavourite
            if(character.IsFavourite){
                favouriteIcon.setImageResource(R.drawable.baseline_favorite_24)
                favouriteIcon
                    .animate()
                    .scaleX(1.5f)
                    .scaleY(1.5f)
                    .setDuration(300)
                    .withEndAction{
                        favouriteIcon
                            .animate()
                            .scaleX(1f)
                            .scaleY(1f)
                            .setDuration(300)
                            .start()
                    }
            }
            else{
                favouriteIcon.setImageResource(R.drawable.baseline_favorite_border_24)
            }
        }
    }

}