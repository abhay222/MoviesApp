package com.neuronappz.moviesapp.data

import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResponse
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {
    suspend fun getUpcomingMovies(): Flow<Resource<UpcomingMoviesResponse>>
}