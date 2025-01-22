package com.example.narutowiki.presentation

import android.os.Bundle
import android.system.Os.bind
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.narutowiki.R
import com.example.narutowiki.databinding.ActivityMainBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
