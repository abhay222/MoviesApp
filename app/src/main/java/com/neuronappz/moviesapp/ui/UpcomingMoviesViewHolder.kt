package com.neuronappz.moviesapp.ui

import androidx.recyclerview.widget.RecyclerView
import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResult
import com.neuronappz.moviesapp.databinding.UpcomingMoviesItemBinding
import com.neuronappz.moviesapp.utils.IMAGE_BASE_URL
import com.neuronappz.moviesapp.utils.loadImage
import com.squareup.picasso.Picasso

class UpcomingMoviesViewHolder(private val itemBinding: UpcomingMoviesItemBinding): RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: UpcomingMoviesResult, mItemListener: UpcomingMoviesAdapter.UpcomingMoviesAdapterListener) {
            itemBinding.tvName.text = item.title
            itemBinding.tvCaption.text = item.overview
            itemBinding.ivRecipeItemImage.loadImage(IMAGE_BASE_URL + item.poster_path)
            itemBinding.rlRecipeItem.setOnClickListener { mItemListener.onItemClicked(item) }
    }
}
