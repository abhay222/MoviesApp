package com.neuronappz.moviesapp.ui.upcoming.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.neuronappz.moviesapp.R
import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResult
import com.neuronappz.moviesapp.utils.IMAGE_BASE_URL
import com.neuronappz.moviesapp.utils.loadImage

private const val MOVIE_DATA = "movie_data"

class MoviesDetailsFragment : Fragment() {
    private var movieResponse: UpcomingMoviesResult? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieResponse = it.getParcelable(MOVIE_DATA)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name : TextView = view.findViewById(R.id.tv_name)
        val description : TextView = view.findViewById(R.id.tv_description)
        val poster : ImageView = view.findViewById(R.id.iv_poster)

        poster.loadImage(IMAGE_BASE_URL + movieResponse?.poster_path)
        name.text = movieResponse?.title
        description.text = movieResponse?.overview


    }

    companion object {
        @JvmStatic
        fun newInstance(data: UpcomingMoviesResult) =
            MoviesDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MOVIE_DATA, data)
                }
            }
    }
}