package com.neuronappz.moviesapp.data.remote

import com.neuronappz.moviesapp.data.Resource
import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResponse

interface RemoteDataSource {
    suspend fun getUpcomingMovies(): Resource<UpcomingMoviesResponse>
}