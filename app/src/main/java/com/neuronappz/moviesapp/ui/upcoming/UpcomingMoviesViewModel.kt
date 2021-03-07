package com.neuronappz.moviesapp.ui.upcoming

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neuronappz.moviesapp.data.DataRepositorySource
import com.neuronappz.moviesapp.data.Resource
import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResponse
import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResult
import com.neuronappz.moviesapp.utils.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpcomingMoviesViewModel @Inject constructor(private val repository: DataRepositorySource) : ViewModel() {
    private val _upcomingMoviesResponse = MutableLiveData<Resource<UpcomingMoviesResponse>>()
    val upcomingMoviesResponse: LiveData<Resource<UpcomingMoviesResponse>> get() = _upcomingMoviesResponse

 private val _upcomingMoviesDetail = MutableLiveData<SingleEvent<UpcomingMoviesResult>>()
    val upcomingMoviesDetail: LiveData<SingleEvent<UpcomingMoviesResult>> get() = _upcomingMoviesDetail

    fun getUpcomingMovies() {
        viewModelScope.launch {
            _upcomingMoviesResponse.value = Resource.Loading()
            repository.getUpcomingMovies().collect {
                _upcomingMoviesResponse.value = it
            }
        }
    }

    fun openUpcomingMoviesDetails(item: UpcomingMoviesResult) {
        _upcomingMoviesDetail.value = SingleEvent(item)
    }
}