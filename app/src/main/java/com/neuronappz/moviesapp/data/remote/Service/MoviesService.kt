package com.neuronappz.moviesapp.data.remote.Service

import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MoviesService {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(): Response<UpcomingMoviesResponse>
}