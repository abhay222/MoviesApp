package com.neuronappz.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neuronappz.moviesapp.ui.UpcomingMoviesFragment
import com.neuronappz.moviesapp.utils.showFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(R.id.main_layout, UpcomingMoviesFragment.newInstance())
    }
}