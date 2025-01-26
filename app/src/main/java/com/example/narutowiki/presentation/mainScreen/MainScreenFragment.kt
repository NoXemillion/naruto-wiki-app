package com.example.narutowiki.presentation.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.narutowiki.R
import com.example.narutowiki.databinding.FragmentMainScreenBinding
import com.example.narutowiki.presentation.AnimeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {

    private val binding: FragmentMainScreenBinding by viewBinding()
    private val animeViewModel: AnimeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.mRecyclerView
        val bottomNavigationView = binding.bottomNavigation
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.setHasFixedSize(true)
        var adapter = AnimeAdapter(animeViewModel)
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            private var isScrollDown = false

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if(dy > 0 && !isScrollDown){
                    bottomNavigationView.animate().translationY(bottomNavigationView.height.toFloat()).start()
                    isScrollDown = true
                }
                else if(dy < 0 && isScrollDown){
                    bottomNavigationView.animate().translationY(0f).start()
                    isScrollDown = false
                }
            }
        })

    }
}