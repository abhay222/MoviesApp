package com.neuronappz.moviesapp.data

import com.neuronappz.moviesapp.data.dataModels.UpcomingMoviesResponse
import com.neuronappz.moviesapp.data.local.LocalData
import com.neuronappz.moviesapp.data.remote.RemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepository @Inject constructor(
    val remoteDataSource: RemoteData,
    val localDataSource: LocalData,
    private val ioDispatcher: CoroutineContext
) : DataRepositorySource {

    override suspend fun getUpcomingMovies(): Flow<Resource<UpcomingMoviesResponse>> {
        return flow { emit(remoteDataSource.getUpcomingMovies())
        }.flowOn(ioDispatcher)
    }

}