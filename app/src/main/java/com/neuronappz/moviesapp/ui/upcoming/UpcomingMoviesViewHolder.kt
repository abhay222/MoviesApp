package com.neuronappz.moviesapp.ui.upcoming

import androidx.recyclerview.widget.RecyclerView
import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResult
import com.neuronappz.moviesapp.databinding.UpcomingMoviesItemBinding
import com.neuronappz.moviesapp.ui.upcoming.UpcomingMoviesAdapter
import com.neuronappz.moviesapp.utils.IMAGE_BASE_URL
import com.neuronappz.moviesapp.utils.loadImage

class UpcomingMoviesViewHolder(private val itemBinding: UpcomingMoviesItemBinding): RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: UpcomingMoviesResult, mItemListener: UpcomingMoviesAdapter.UpcomingMoviesAdapterListener) {
            itemBinding.tvName.text = item.title
            itemBinding.tvDescription.text = item.overview
            itemBinding.ivRecipeItemImage.loadImage(IMAGE_BASE_URL + item.poster_path)
            itemBinding.rlRecipeItem.setOnClickListener { mItemListener.onItemClicked(item) }
    }
}
