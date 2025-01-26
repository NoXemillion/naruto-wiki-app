package com.example.narutowiki.presentation.mainScreen

import androidx.recyclerview.widget.DiffUtil
import com.example.narutowiki.data.dataClasses.Character

class AnimeDiffCallBack: DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}