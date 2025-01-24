package com.example.narutowiki.presentation

import android.os.Bundle
import android.system.Os.bind
import android.util.Log
import android.view.View
import android.viewbinding.library.activity.viewBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.narutowiki.R
import com.example.narutowiki.databinding.ActivityMainBinding
import com.example.narutowiki.presentation.introduction.IntroFragment
import com.example.narutowiki.presentation.mainScreen.AnimeAdapter
import com.example.narutowiki.presentation.mainScreen.MainScreenFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()
    private val animeViewModel: AnimeViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        observeLoadingState()
    }
    private fun observeLoadingState() {
        animeViewModel.isLoading.observe(this) { isLoading ->
            Log.d("TAG2" , isLoading.toString())
            if(isLoading){
                showIntroFragment()
            }
            else{
                Log.d("TAG" , "Okay its working!")
                showMainScreenFragment()
            }
        }
    }
    private fun showIntroFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragment , IntroFragment())
            .commit()
    }
    private fun showMainScreenFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragment , MainScreenFragment())
            .commit()
    }
}
