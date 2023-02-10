package com.arturomarmolejo.exomusicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.arturomarmolejo.exomusicapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        val hostFragment =
//            supportFragmentManager.findFragmentById(R.id.frag_container) as NavHostFragment
//
//        binding.navigationBottom.setupWithNavController(hostFragment.navController)
    }
}