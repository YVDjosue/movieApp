package com.wanku.movieapp.data.network

import com.wanku.movieapp.core.RetrofitHelper
import com.wanku.movieapp.data.model.MovieModel
import com.wanku.movieapp.data.model.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(
    private val api:MovieApiClient
){

    suspend fun getMovies():List<ResultModel>{
        return withContext(Dispatchers.IO){
            //val response = retrofit.create(MovieApiClient::class.java).getAllMovies()
            val response = api.getAllMovies()
            response.body()?.results ?: emptyList()
        }
    }
}