package com.example.narutowiki.presentation

import android.os.Bundle
import android.system.Os.bind
import android.util.Log
import android.view.View
import android.viewbinding.library.activity.viewBinding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.narutowiki.R
import com.example.narutowiki.common.Resource
import com.example.narutowiki.databinding.ActivityMainBinding
import com.example.narutowiki.domain.use_cases.GetAnimeUseCase
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
        animeViewModel.fetchAnimeState()
    }
    private fun observeLoadingState() {
        animeViewModel.animeState.observe(this){ state->
            when(state) {
                is Resource.Loading -> {
                    showIntroFragment()
                }

                is Resource.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                }
                is Resource.Success -> {
                    showMainScreenFragment()
                }
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
