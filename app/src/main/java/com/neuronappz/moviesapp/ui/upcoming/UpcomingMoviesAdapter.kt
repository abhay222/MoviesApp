package com.neuronappz.moviesapp.ui.upcoming

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResult
import com.neuronappz.moviesapp.databinding.UpcomingMoviesItemBinding

class UpcomingMoviesAdapter(
    private val upcomingMoviesViewModel: UpcomingMoviesViewModel,
    private val mMoviesList: MutableList<UpcomingMoviesResult>
) : RecyclerView.Adapter<UpcomingMoviesViewHolder>() {
    val TAG = UpcomingMoviesAdapter::class.java.simpleName

    private val mUpcomingMoviesAdapterListener = object :
        UpcomingMoviesAdapterListener {
        override fun onItemClicked(item: UpcomingMoviesResult) {
            upcomingMoviesViewModel.openUpcomingMoviesDetails(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMoviesViewHolder {
        val itemBinding =
            UpcomingMoviesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UpcomingMoviesViewHolder(
            itemBinding
        )
    }

    override fun getItemCount(): Int {
        return mMoviesList.size
    }

    override fun onBindViewHolder(holder: UpcomingMoviesViewHolder, position: Int) {
        holder.bind(mMoviesList[position], mUpcomingMoviesAdapterListener)
    }

    interface UpcomingMoviesAdapterListener {
        fun onItemClicked(item: UpcomingMoviesResult)
    }

}