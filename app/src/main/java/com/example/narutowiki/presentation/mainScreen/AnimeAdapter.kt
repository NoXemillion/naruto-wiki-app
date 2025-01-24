package com.example.narutowiki.presentation.mainScreen

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.narutowiki.R
import com.example.narutowiki.data.dataClasses.Character

class AnimeAdapter(
    private val characters: MutableList<Character>
): RecyclerView.Adapter<AnimeAdapter.ViewHolder>(){
    private val _isClicked = MutableLiveData<Boolean>(false)
    val isClicked: MutableLiveData<Boolean> get() = _isClicked

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.name)
        val cardViewBackground: ImageView = itemView.findViewById(R.id.cardViewBackground)
        val favouriteIcon: ImageButton = itemView.findViewById(R.id.characterIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = characters[position].name
        if (characters[position].images.isNullOrEmpty()) {
            holder.cardViewBackground.setImageResource(R.drawable.error_icon)
        } else {
            holder.cardViewBackground.load(characters[position].images.first()) {
                Log.d("TAG" , characters[position].images.first().toString())
                crossfade(true)
                placeholder(R.drawable.error_icon)
                error(R.drawable.error_icon)
            }
        }

        holder.favouriteIcon.setOnClickListener{
            if(isClicked.value == true){
                holder.favouriteIcon.setImageResource(R.drawable.baseline_favorite_24)
                holder.favouriteIcon
                    .animate()
                    .scaleX(1.5f)
                    .scaleY(1.5f)
                    .setDuration(300)
                    .withEndAction{
                        holder.favouriteIcon
                            .animate()
                            .scaleX(1f)
                            .scaleY(1f)
                            .setDuration(300)
                            .start()
                    }
            }
            else{
                holder.favouriteIcon.setImageResource(R.drawable.baseline_favorite_border_24)
            }
            isClicked.value = !isClicked.value!!

        }
    }
}