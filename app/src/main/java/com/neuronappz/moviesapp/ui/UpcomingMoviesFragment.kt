package com.neuronappz.moviesapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProviders
import com.neuronappz.moviesapp.R
import com.neuronappz.moviesapp.data.Resource
import com.neuronappz.moviesapp.databinding.FragmentUpcomingMoviesBinding
import com.neuronappz.moviesapp.utils.BaseViewModelFactory
import com.neuronappz.moviesapp.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResponse
import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResult


@AndroidEntryPoint
class UpcomingMoviesFragment : Fragment() {

//    lateinit var dataBinding : FragmentUpcomingMoviesBinding
    private val upcomingMoviesViewModel: UpcomingMoviesViewModel by viewModels()
    private var upcomingAdapter : UpcomingMoviesAdapter? = null
    private var mMoviesList : MutableList<UpcomingMoviesResult> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_upcoming_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        upcomingAdapter = UpcomingMoviesAdapter(upcomingMoviesViewModel, mMoviesList)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_list)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = upcomingAdapter
        recyclerView.setHasFixedSize(true)

        observe(upcomingMoviesViewModel.upcomingMoviesResponse, ::handleRecipesList)
        upcomingMoviesViewModel.getUpcomingMovies()
    }

    val TAG = UpcomingMoviesFragment::class.java.simpleName

    private fun handleRecipesList(status: Resource<UpcomingMoviesResponse>) {
        when (status) {
            is Resource.Loading -> {
                showLoadingView()
                Log.d(TAG, "handleRecipesList: loading")
            }
            is Resource.Success -> status.data?.let {
                mMoviesList.clear()
                mMoviesList.addAll(it.results)
                upcomingAdapter?.notifyDataSetChanged()

                Log.d(TAG, "handleRecipesList: Success")
            }
            is Resource.DataError -> {
                Log.e(TAG, "handleRecipesList: error")
                //showDataView(false)
                //status.errorCode?.let { recipesListViewModel.showToastMessage(it) }
            }
        }
    }

    private fun showLoadingView() {

    }

    companion object {
        @JvmStatic
        fun newInstance() =
                UpcomingMoviesFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}