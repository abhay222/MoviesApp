package com.neuronappz.moviesapp.ui.upcoming.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.neuronappz.moviesapp.R
import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResult
import com.neuronappz.moviesapp.utils.DETAILS_ITEM_KEY
import com.neuronappz.moviesapp.utils.showFragment

class UpcomingDetailActivity : AppCompatActivity() {
    val TAG = UpcomingDetailActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upcoming_detail)
        val details: UpcomingMoviesResult? = intent.getParcelableExtra(DETAILS_ITEM_KEY)

        Log.d(TAG, "onCreate: ")

        showFragment(R.id.main_layout, MoviesDetailsFragment.newInstance(details!!), false)
    }
}