package com.example.narutowiki.presentation.introduction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.narutowiki.R
import com.example.narutowiki.databinding.IntroFragmentBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class IntroFragment : Fragment() {
    private val binding: IntroFragmentBinding by viewBinding(IntroFragmentBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.intro_fragment , container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.introImage.load("https://i.pinimg.com/736x/9b/e3/21/9be3212ad2d9e9f8003f7f08914fe2cd.jpg"){
            crossfade(true)
            placeholder(R.drawable.intro_background)
            error(R.drawable.error_background)
        }
    }


}