package com.neuronappz.moviesapp.data.remote

import com.neuronappz.moviesapp.data.Resource
import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResponse
import com.neuronappz.moviesapp.data.remote.Service.MoviesService
import com.neuronappz.moviesapp.utils.NETWORK_ERROR
import com.neuronappz.moviesapp.utils.NO_INTERNET_CONNECTION
import com.neuronappz.moviesapp.utils.NetworkConnectivity
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject constructor(private val serviceGenerator: ServiceGenerator, private val networkConnectivity: NetworkConnectivity) : RemoteDataSource {

    override suspend fun getUpcomingMovies(): Resource<UpcomingMoviesResponse> {
        val moviesService = serviceGenerator.createService(MoviesService::class.java)
        return when (val response = processCall(moviesService::getUpcomingMovies)) {
            is UpcomingMoviesResponse -> {
                Resource.Success(data = response)
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }

    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!networkConnectivity.isConnected()) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }
}